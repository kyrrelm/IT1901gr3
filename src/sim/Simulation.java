package sim;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Random;

import server.Server;

import map.Constants;

import db.DBAccess;

import helpclasses.Message;
import helpclasses.Sheep;

/**
 * Simulation object must be created, run and maintained for as long as the simulation
 * is to take place.
 * 1. Retrieve data from server
 * 2. Store data in memory
 * 3. Increment position, random pulse within certain range
 * (unless sheep.attacked == true) and random temp within certain range
 * 4. Send updated data to server
 * 
 * This simulation is supposed to simulate the sheep collars sending data every
 * x seconds to the server. There is no need for permanent storage of sim data, 
 * we're just simulating the collars sending data en masse.
 */
public class Simulation extends Thread{

	ArrayList<Message> messages;
	
	public boolean stop = false;
	public int refreshRate; 
	
	/**
	 * check every 5 seconds if there is an alarm!
	 */
	public int alarmRate = 300000;

	private int minPulse = 40;
	private int maxPulse = 100;

	private int minTemp = 35;
	private int maxTemp = 42;
	/* End simulation variable ranges */
	
	/**
	 * The simulation constructor, any values you'd want to variable between different simulations should
	 * be supplied as a constructor parameter.
	 * @param maxHerdX The maximum movement for the herd
	 * @param maxHerdY
	 * @param refreshRate Amount of milliseconds between each value refresh in sheep ArrayList and DB dump
	 */
	public Simulation(int refreshRate)
	{
		
		// kaller Thread
		super("SimulationThread");
		
		
		messages = new ArrayList<Message>();
		this.refreshRate = refreshRate;
		getData();
	}
	
	/**
	 * Method called by server to start the thread.
	 * @author halvor
	 */
	public void run()
	{
		simLoop();
	}
	

	/**
	 * The simulation loop. This will rerun the randomize methods at given refreshRate and then deploy changes
	 * to database.
	 */
	public void simLoop()
	{
		long waitTime = 0;
		while(!stop)
		{
			if (waitTime >= refreshRate)
			{
				randomPos();
				randomTemp();
				randomPulse();
				setData();
				
				waitTime = 0;
			}
			
			generateAlarm();
			
			try { Thread.sleep(alarmRate); } catch (InterruptedException e) { e.printStackTrace(); } //tråden sover
			
			// for speedy generering
			//try { Thread.sleep(refreshRate); } catch (InterruptedException e) { e.printStackTrace(); } //tråden sover
			waitTime += alarmRate;
		}
	}

	/**
	 * Gets all the data from the database. Need only run it once per simulation.
	 */
	public void getData()
	{
		// en liste med sauene er ikke særlig brukbar da den ikke inneholder posisjoner. (I DB)
		// IMO burde vi endre DBACCESS.addsheep slik at den lager en message i databasen når en sau er addet til DB (for å forhindre at sauer som ikke har noen meldinger blir usynlige for Simulation)
		// og operere med meldinger her.
		messages = DBAccess.getLastMessages();
	}

	/**
	 * Takes all the data and stores it in the database with given refreshRate
	 */
	public void setData()
	{
		//DEBUG:
		System.out.println("Just updated all sheep");
		// TODO: Fix int in DB method, float in messages and simulation (Temperature)
		for (Message m: messages)
			DBAccess.addMessage(m.getPulse(), (int)m.getTemperature(), m.getStatus(), m.getPositionX(), m.getPositionY(), m.getSheepId());
		
		//DBAccess.updateAllSheep(null);
		Server.fireUpdateMessages();
	}

	/**
	 * Random movement of all sheeps, this needs some minor polishing but works well enough for a rudimentary simulation
	 * sets movement within range maxHerdX and maxHerdY
	 * 
	 * 
	 * Bug: position is completely random, does not take into account any max movement per day.
	 *  ^Halvor. 
	 */
	public void randomPos() 
	{
		
		for(Message m: messages)
		{
			Random r = new Random();
			double x = Constants.minLon + (Constants.maxLon - Constants.minLon) * r.nextDouble();
			double y = Constants.minLat +  (Constants.maxLat - Constants.minLat) * r.nextDouble();
			m.setPos(x, y);
		}
		
	}

	/**
	 * Sets random temperature between minTemp and maxTemp
	 */
	public void randomTemp()
	{
		
		for(Message m: messages)
		{
			int tempRandom = minTemp +(int)(Math.random()*maxTemp);
			m.setTemperature(tempRandom);
		}
		
	}

	/**
	 * Sets a random pulse between minPulse and maxPulse
	 */
	public void randomPulse()
	{
		
		for(Message m: messages)
		{
			int pulseRandom = minPulse +(int)(Math.random()*maxPulse);
			m.setPulse(pulseRandom);
		}
		
	}
	
	public void stopThread()
	{
		stop = true;
	}
	
	
	
	public boolean generateAlarm()
	{
		Random r = new Random();
		
		if (r.nextInt(12*24)  == 0)
		{
			int randomIndex = r.nextInt(messages.size());
			while (messages.get(randomIndex).isAlarm())
				randomIndex = r.nextInt(messages.size());
			
			// make that shit!
			double x = Constants.minLon + (Constants.maxLon - Constants.minLon) * r.nextDouble();
			double y = Constants.minLat +  (Constants.maxLat - Constants.minLat) * r.nextDouble();
			db.DBAccess.addMessage(0, 0, 1, x, y, messages.get(randomIndex).getSheepId());
			
			messages.remove(randomIndex);
			// fire  alarm på randomIndex
			Server.fireAlarm(messages.get(randomIndex));
			return true;
		}
		return false;
	}
}
