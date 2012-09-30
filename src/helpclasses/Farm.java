package helpclasses;

public class Farm {
	
	private int farmId;
	private int ownerId;
	private String name;
	
	public Farm(int farmId, String name, int ownerId) {
		this.farmId = farmId;
		this.name = name;
		this.ownerId = ownerId;
	}
	
	public int getFarmId() {
		return farmId;
	}
	
	public String getName() {
		return name;
	}
	
	public int getOwnerId() {
		return ownerId;
	}
}
