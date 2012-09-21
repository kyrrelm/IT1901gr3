package helpclasses;

public class Message {
	int messageID;
	//datetime dateTime;
	private int pulse;
	private float temperature;
	private int positionX;
	private int positionY;
	private int sheepID;
	private int status;
	
	public Message(int messageID, int pulse, float temperature, int positionX,
			int positionY, int sheepID, int status) {
		super();
		this.messageID = messageID;
		this.pulse = pulse;
		this.temperature = temperature;
		this.positionX = positionX;
		this.positionY = positionY;
		this.sheepID = sheepID;
		this.status = status;
	}
	
	public int getMessageID() {
		return messageID;
	}
	
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	
	public int getPulse() {
		return pulse;
	}
	
	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
	
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public int getSheepID() {
		return sheepID;
	}
	
	public void setSheepID(int sheepID) {
		this.sheepID = sheepID;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	

}
