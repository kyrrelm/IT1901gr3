package server;

import helpclasses.CommEnum;
import helpclasses.CommMessage;
import helpclasses.Message;
import helpclasses.Owner;

import java.util.ArrayList;

import db.DBAccess;

import sim.Simulation;


public class Server 
{
	
	/***
	 * @author halvor
	 * 
	 * OwnerID of all logged in clients.
	 */
	public static ArrayList<Integer> loggedInClients = new ArrayList<Integer>();
	public static SocketServer sockServ;
	public static void main(String asdasd[]) throws InstantiationException, IllegalAccessException
	{
		//force ipv4
		System.setProperty("java.net.preferIPv4Stack" , "true");
		
		// open DB connection!
		db.DBAccess.open();
		
		// start simulation thread!
		Simulation sim = new Simulation(28800000);
		//Simulation sim = new Simulation(10000);
		sim.start();
		
		sockServ = new SocketServer(6667);
		
		sockServ.run();
		
		sockServ.close();
		
		db.DBAccess.close();
		
	}
	
	
	public static void fireAlarm(Message m)
	{
		// skjekk a lle owners, eieren er pålogget send en CommMessage<?>(CommEnum.ALARM, null)
		Owner o = db.DBAccess.getOwnerBySheepID(m.getSheepId());
		// send email
		String title = "Your sheep is under attack!";
		String title2 = "Your partner's sheep is under attack!";
		
		String body  = "The sheep with ID " + m.getSheepId() + " was attacked! \n";
		body        += "Date: "+ m.getDateTime() + "\n";
		body        += "Position: (" + m.getPositionY() +", "  +m.getPositionX() + ")\n";
		/*
		EmailSender.sendEmail(o.getPrimaryMail(), title, body);
		EmailSender.sendEmail(o.getSecondaryMail(), title2, body);
		*/
		//SMSSender.SendSMS(body)
		
		
		System.out.println("LOL");
		
		// check if that user is logged on!
		
		if (loggedInClients.contains(o.getOwnerId()))
		{
			ServerThread st =  sockServ.getThread(o.getOwnerId());
			CommMessage<Integer> cm = new CommMessage<Integer>(CommEnum.NEWALARM, null);
			st.sendMessage(cm);
		}
		
		
	}
	
	public static void fireUpdateMessages()
	{
		ArrayList<ServerThread> sts =  sockServ.getThreads();
		for (ServerThread st: sts)
		{
			if (st.getLoggedIn())
			{
				CommMessage<Integer> cm = new CommMessage<Integer>(CommEnum.NEWMESSAGES, null);
				st.sendMessage(cm);
			}

		}
			
	}

}
