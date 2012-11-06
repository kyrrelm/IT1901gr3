package server;

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
	public static ArrayList<Owner> loggedInClients = new ArrayList<Owner>();
	
	public static void main(String asdasd[]) throws InstantiationException, IllegalAccessException
	{
		//force ipv4
		System.setProperty("java.net.preferIPv4Stack" , "true");
		
		// open DB connection!
		db.DBAccess.open();
		
		// start simulation thread!
		//Simulation sim = new Simulation(1000, 1000, 1000000);
		//sim.start();
		
		SocketServer sockServ = new SocketServer(6667);
		
		sockServ.run();
		
		sockServ.close();
		
		db.DBAccess.close();
		
	}

}
