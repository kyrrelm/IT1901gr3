package client;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import helpclasses.CommEnum;
import helpclasses.CommMessage;
import helpclasses.Farm;
import helpclasses.Message;
import helpclasses.Owner;
import helpclasses.Sheep;

/**
 * This class handles server->client messages and the actions that these messages require. For example updating the ServerData.messages arraylist when a message update has come.
 * 
 * 
 * @author halvor
 *
 */
public class ClientUnpacker {

	public static CommMessage<?> unpackClientMessage(CommMessage<?> msg)
	{
		ArrayList<?> params = msg.getParamList();

		if (msg.getMessageName() == CommEnum.LOGINSUCCESSFUL)
		{
			// logged in
			ServerData.isLoggedIn = true;
			//Setter owner i ServerData ved Login
			ServerData.owner = ((Owner) params.get(0));
		}

		if (msg.getMessageName() == CommEnum.LOGINFAILED)
		{
			// failed log in
			// -- GUI.popErrorWindow("Login failed try again!")
			// -- GUI.segLoggedIn(false);
		}

		if (msg.getMessageName() == CommEnum.NOTLOGGEDIN)
		{
			// attempted to do something that requires log in without being logged in
			// -- GUI.popErrorWindow("You need to be logged in to execute this command LIKELY connection problem or a code bug");
			// -- GUI.setLoggedIn(false);
		}

		if (msg.getMessageName() == CommEnum.MESSAGESREPLY)
		{	
			ArrayList<ArrayList<Message>> sortedMsg = new ArrayList<ArrayList<Message>>();
			ArrayList<ArrayList<Message>> tmp = new ArrayList<ArrayList<Message>>();
			for (ArrayList<Message> p : (ArrayList<ArrayList<Message>>)params) {
				if (p.get(0).isAlarm()) {
					sortedMsg.add(p);
				}else{
					tmp.add(p);
				}
			}
			sortedMsg.addAll(tmp);
			ServerData.messages = sortedMsg;
		}

		if (msg.getMessageName() == CommEnum.FARMSREPLY)
		{

			ServerData.farms = (ArrayList<Farm>) params;
		}
		if (msg.getMessageName() == CommEnum.SHEEPREPLY)
		{

			ServerData.sheep = (ArrayList<Sheep>) params;
		}

		if (msg.getMessageName() == CommEnum.SUCCESS)
		{
			// Trengs denne? Kanskje en liten grafik i et hj�rne som viser at kommandoen ble ekskevert riktig, ikke et popup selvsagt.
			System.out.println("Transfer was a success!");

		}
		
		if (msg.getMessageName() == CommEnum.NEWMESSAGES)
		{
			JOptionPane.showMessageDialog(client.Client.hub, "Hit refresh to receive your new messages.", "New messages", JOptionPane.INFORMATION_MESSAGE);
			
		}
		if (msg.getMessageName() == CommEnum.NEWALARM)
		{
			System.out.println("HEHEHE");
			JOptionPane.showMessageDialog(client.Client.hub, "Hit refresh to receive your new urgent message.", "ALARM!", JOptionPane.WARNING_MESSAGE);
		}
		
		//If username is already taken, set the global variable
		// isUserNameTaken in RegisterUser.java to true
		if (msg.getMessageName() == CommEnum.USERNAMEALREADYTAKEN)
		{
			gui.RegisterNewUser.isUsernameTaken = true;
		}
		
		//If email address is already taken, set the global variable
		// isEmailAddressTaken in RegisterUser.java to true
		if(msg.getMessageName() == CommEnum.EMAILADDRESSALREADYTAKEN)
		{
			gui.RegisterNewUser.isEmailAddressTaken = true;
		}

		return null;
	}

}
