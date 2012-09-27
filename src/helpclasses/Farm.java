package helpclasses;

public class Farm {
	
	private int farmId;
	private int ownerId;
	private String name;
	
	public Farm(int farmId, String name, int ownerId) {
		this.farmId = farmId;
		this.ownerId = ownerId;
		this.name = name;
	}
	
	public int getFarmId() {
		return farmId;
	}
	
	public int getOwnerId() {
		return ownerId;
	}
	
	public String getName() {
		return name;
	}
}
