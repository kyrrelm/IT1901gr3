package client;

import java.util.ArrayList;

import helpclasses.CommMessage;

public class ClientUnpacker {
	
	public static CommMessage<?> unpackClientMessage(CommMessage<?> msg)
	{
		ArrayList<?> params = msg.getParamList();
		
		if (msg.getMessageName().equals("LoginSuccessful"))
		{
			// logged in
			// -- GUI.setLoggedIn(true);
		}
		
		if (msg.getMessageName().equals("LoginFailed"))
		{
			// failed log in
			// -- GUI.popErrorWindow("Login failed try again!")
			// -- GUI.segLoggedIn(false);
		}
		
		if (msg.getMessageName().equals("NotLoggedIn"))
		{
			// attempted to do something that requires log in without being logged in
			// -- GUI.popErrorWindow("You need to be logged in to execute this command LIKELY connection problem or a code bug");
			// -- GUI.setLoggedIn(false);
		}
		
		if (msg.getMessageName().equals("messages"))
		{
			// a return of all messages regarding the logged in users.
			// edit en ListModel som finnes i GUI? er vel det greieste.
			
			// eksempel: her er det returnert en ArrayList med messages!
			// GUI.setMessageListModel(params) ??
		}
		
		if (msg.getMessageName().equals("Success!"))
		{
			// Trengs denne? Kanskje en liten grafik i et hjørne som viser at kommandoen ble ekskevert riktig, ikke et popup selvsagt.
			
		}
		
		return null;
	}
	
}
