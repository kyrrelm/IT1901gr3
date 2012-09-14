package helpclasses;


// det her burde være en subclass for en saueupdate
// å kun ha sheep uten en message virker rimelig ubrukelig
public class Sheep 
{
	private int sheepID;
	private int birthYear;
	private int farmID;
	private int ownerID;
	
	public Sheep(int sID, int bY, int fID, int oID)
	{
		this.sheepID = sID;
		this.birthYear = bY;
		this.farmID = fID;
		this.ownerID = oID;
		
	}

	public int getSheepID() {
		return sheepID;
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
