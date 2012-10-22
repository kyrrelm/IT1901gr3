package client;

import java.util.ArrayList;

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
			System.out.println(((Owner) params.get(0)).getFirstName());
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

			System.out.println(params.size());
			ServerData.messages = (ArrayList<Message>) params;
		}
		if (msg.getMessageName() == CommEnum.NEWMESSAGES)
		{
			ServerData.messages = (ArrayList<Message>) params;
			System.out.println("New messages received from server!");
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
			// Trengs denne? Kanskje en liten grafik i et hjørne som viser at kommandoen ble ekskevert riktig, ikke et popup selvsagt.
			System.out.println("Transfer was a success!");

		}

		return null;
	}

}
