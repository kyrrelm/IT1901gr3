package server;

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
		// open DB connection!
		db.DBAccess.open();
		
		// start simulation thread!
		//Simulation sim = new Simulation(100, 100, 1000000);
		//sim.run();
		DBAccess.getLastMessages();
		SocketServer sockServ = new SocketServer(6667);
		
		sockServ.run();
		
		sockServ.close();
		
		db.DBAccess.close();
		
	}

}
