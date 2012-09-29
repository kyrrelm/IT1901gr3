package sim;

import java.util.ArrayList;
import helpclasses.Sheep;

/**
 * Simulation object must be created, run and maintained for as long as the simulation
 * is to take place.
 * 1. Retrieve data from database
 * 2. Store data in memory
 * 3. Increment position, random pulse within certain range
 * (unless sheep.attacked == true) and random temp within certain range
 * 4. Send updated data to server for database update at given refresh rate
 * 
 * This simulation is supposed to simulate the sheep collars sending data every
 * x seconds to the server, which then updates the database
 */
public class Simulation {

	ArrayList<Sheep> sheep;
	
	
	public void getData() //maybe run this in constructor?
	{
		// ask server for database data in object form (sheep)
		// store data in datastructure (list)
	}
	
	public void randomPos()
	{
		
	}
	
	public void randomTemp()
	{
		
	}
	
	public void randomPulse()
	{
		
	}
}
