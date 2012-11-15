package client;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import helpclasses.CommEnum;
import helpclasses.CommMessage;
import helpclasses.Farm;
import helpclasses.Message;
import helpclasses.Owner;
import helpclasses.Sheep;

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
			// a return of all messages regarding the logged in users.
			// edit en ListModel som finnes i GUI? er vel det greieste.

			// eksempel: her er det returnert en ArrayList med messages!
			// GUI.setMessageListModel(params) ??

			
			ServerData.messages = (ArrayList<ArrayList<Message>>) params;
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
