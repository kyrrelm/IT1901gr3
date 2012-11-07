package server;

import helpclasses.Message;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import map.Constants;

public class InputScanner extends Thread
{
	private boolean stop = false;
	Scanner scanner;
	public InputScanner()
	{
		super("InputScanner");
		
		scanner = new Scanner(System.in);
		
	}

	public void run()
	{
		listenToInput();
		
	}
	
	public void listenToInput()
	{
		while (!stop)
		{
					
			String input = scanner.nextLine();
			
			handleInput(input);
		}
	}
	
	public void handleInput(String input)
	{
		if (input.length() < 5)
			return;
		if (input.charAt(0) == 'K')
		{
			String ownerID = input.substring(2, 5);

			killSheepForOwner(Integer.parseInt(ownerID));
		}
	}
	
	public void stopThread()
	{
		stop = true;
	}

	
	public void killSheepForOwner(int ownerID)
	{
		ArrayList<Message> messages = db.DBAccess.getLastMessages();
		ArrayList<Message> tmp = new ArrayList<Message>();
		
		for (Message m: messages)
		{
			if (m.getSheep().getOwnerId() == ownerID)
			{
				tmp.add(m);
			}
		}
		
		Random r = new Random();
		
		
		if (tmp.size() < 2)
			return;
		int randomIndex = r.nextInt(tmp.size());
		while (tmp.get(randomIndex).isAlarm())
			randomIndex = r.nextInt(tmp.size());
		
		
		// make that shit!
		double x = Constants.minLon + (Constants.maxLon - Constants.minLon) * r.nextDouble();
		double y = Constants.minLat +  (Constants.maxLat - Constants.minLat) * r.nextDouble();
		Message tmptmp = db.DBAccess.addMessage(0, 0, 1, x, y, tmp.get(randomIndex).getSheepId());
		System.out.println(tmptmp.getSheepId());
		// fire  alarm på randomIndex
		Server.fireAlarm(tmptmp);;
	}
}
