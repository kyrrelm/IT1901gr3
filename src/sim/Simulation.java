package sim;

import java.util.ArrayList;
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
	
	/* Simulation variable ranges */
	private int minFlock; //the minimum movement for the flock
	private int maxFlock; //the maximum movement for the flock

	private int minLocal; //the mininum movement for the sheep
	private int maxLocal; //the maximum movement for the sheep

	private int minPulse;
	private int maxPulse;

	private int minTemp;
	private int maxTemp;
	
	private double minLongitude;
	private double maxLongitude;
	private double minLatitude;
	private double maxLatitude;
	
	/* End simulation variable ranges */
	
	
	public Simulation(int minFlock, int maxFlock)
	{
		sheep = new ArrayList<Sheep>();
		this.minFlock = minFlock;
		this.maxFlock = maxFlock;
		getData();
	}
	
	public void getData()
	{
		// ask server for database data (sheep)
		// store data in datastructure (list)
	}
	
	public void pos()
	{
		int flockRandom = minFlock + (int)(Math.random()*maxFlock); //in order to keep movement in a consistent flock
		
		for(Sheep s: sheep)
		{
			int localRandom = minLocal +(int)(Math.random()*maxLocal);
			s.incrementPos(flockRandom+localRandom); //
		}
	}
	
	public void randomTemp()
	{
		for(Sheep s: sheep)
		{
			int tempRandom = minTemp +(int)(Math.random()*maxTemp);
			s.setTemp(tempRandom);
		}
	}
	
	public void randomPulse()
	{
		for(Sheep s: sheep)
		{
			int pulseRandom = minPulse +(int)(Math.random()*maxPulse);
			s.setPulse(pulseRandom);
		}
	}
}
