package helpclasses;

import java.io.Serializable;

public class Sheep implements Serializable
{
	private int sheepId;
	private String name;
	private int birthYear;
	private int farmId;
	private int ownerId;
	private boolean attacked;
	//TODO insert coordinate property (I don't know which one is best - Jama)
	private double longitude;
	private double latitude; //set 
	private int pulse;
	private int temp;
	
	public Sheep(int sheepId, String name, int birthYear, int farmId, int ownerId)
	{
		this.sheepId = sheepId;
		this.name = name;
		this.birthYear = birthYear;
		this.farmId = farmId;
		this.ownerId = ownerId;
		attacked = false;
	}

	public int getSheepId() {
		return sheepId;
	}
	
	public String getName() {
		return name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public int getFarmId() {
		return farmId;
	}

	public int getOwnerId() {
		return ownerId;
	}
	
	public String toString() {
		return "| Sheep ID: " + sheepId + "\t | Name: " + name + "\t | Birthyear: " +
				birthYear + "\t | Farm Id: " + farmId + "\t | Owner ID: " + ownerId + " |";
	}

	/**
	 * Increments sheep's movement vector with increment
	 * TODO type of parameter is subject to change as coordinate property for sheep is
	 * finalized
	 * @param i
	 */
	public void incrementPos(int increment) {
		// TODO Auto-generated method stub
		
	}

	public void setPulse(int pulseRandom) {
		// TODO Auto-generated method stub
		
	}

	public void setTemp(int tempRandom) {
		// TODO Auto-generated method stub
		
	}

}
