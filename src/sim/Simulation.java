package sim;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Random;

import db.DBAccess;

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
public class Simulation {

	ArrayList<Sheep> sheep;
	DBAccess db;
	
	public boolean stop = false;
	public int refreshRate; 

	/* Simulation variable ranges */
	private double maxHerdX; 
	private double maxHerdY;

	private int minPulse = 40;
	private int maxPulse = 100;

	private int minTemp = 35;
	private int maxTemp = 42;
	/* End simulation variable ranges */
	
	/**
	 * The simulation constructor, any values you'd want to variable between different simulations should
	 * be supplied as a constructor parameter.
	 * @param db The database reference //TODO maybe this is wrong
	 * @param maxHerdX The maximum movement for the herd
	 * @param maxHerdY
	 * @param refreshRate Amount of milliseconds between each value refresh in sheep ArrayList and DB dump
	 */
	public Simulation(DBAccess db, int maxHerdX, int maxHerdY, int refreshRate)
	{
		sheep = new ArrayList<Sheep>();
		this.maxHerdX = maxHerdX;
		this.maxHerdY = maxHerdY;
		this.refreshRate = refreshRate;
		this.db = db;
		
		getData();
	}

	/**
	 * The simulation loop. This will rerun the randomize methods at given refreshRate and then deploy changes
	 * to database.
	 */
	public void simLoop()
	{
		while(!stop)
		{
			randomPos();
			randomTemp();
			randomPulse();
			setData();
			
			try { Thread.sleep(refreshRate); } catch (InterruptedException e) { e.printStackTrace(); } //tråden sover
		}
	}

	/**
	 * Gets all the data from the database. Need only run it once per simulation.
	 */
	public void getData()
	{
		sheep = db.getAllSheep();
	}

	/**
	 * Takes all the data and stores it in the database with given refreshRate
	 */
	public void setData()
	{
		db.updateAllSheep(sheep);
	}

	/**
	 * Random movement of all sheeps, this needs some minor polishing but works well enough for a rudimentary simulation
	 * sets movement within range maxHerdX and maxHerdY
	 * Bugs: Sheep can move beyond the "wall"
	 * Bugs: Sheep aren't sticking together in a herd (use gravity)
	 */
	public void randomPos() 
	{
		for(Sheep s: sheep)
		{
			Random r = new Random();
			double x, y;
			x = r.nextDouble()*maxHerdX;
			y = r.nextInt()*maxHerdY;
			s.setPos(x, y);
		}
	}

	/**
	 * Sets random temperature between minTemp and maxTemp
	 */
	public void randomTemp()
	{
		for(Sheep s: sheep)
		{
			int tempRandom = minTemp +(int)(Math.random()*maxTemp);
			s.setTemp(tempRandom);
		}
	}

	/**
	 * Sets a random pulse between minPulse and maxPulse
	 */
	public void randomPulse()
	{
		for(Sheep s: sheep)
		{
			int pulseRandom = minPulse +(int)(Math.random()*maxPulse);
			s.setPulse(pulseRandom);
		}
	}
}
