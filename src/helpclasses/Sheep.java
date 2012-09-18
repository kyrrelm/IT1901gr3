package helpclasses;

public class Sheep 
{
	private int sheepID;
	private String name;
	private int birthYear;
	private int farmID;
	private int ownerID;
	
	public Sheep(int sheepID, String name, int birthYear, int farmID, int ownerID)
	{
		this.sheepID = sheepID;
		this.name = name;
		this.birthYear = birthYear;
		this.farmID = farmID;
		this.ownerID = ownerID;
		
	}

	public int getSheepID() {
		return sheepID;
	}
	
	public String getName() {
		return name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public int getFarmID() {
		return farmID;
	}

	public int getOwnerID() {
		return ownerID;
	}
	
	
	

}
