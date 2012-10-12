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
	private double x;
	private double y;
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

	

}
