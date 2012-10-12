package helpclasses;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
	private int messageId;
	private int pulse;
	private int positionX;
	private int positionY;
	private int sheepId;
	private int status;
	private float temperature;
	private Date dateTime;
	private Sheep sheep;
	
	
	public Message(int messageId, Date dateTime, int pulse, float temperature,
			int status, int positionX, int positionY, int sheepId, Sheep sheep) {
		super();
		this.messageId   = messageId;
		this.dateTime    = dateTime;
		this.pulse 		 = pulse;
		this.temperature = temperature;
		this.status 	 = status;
		this.positionX   = positionX;
		this.positionY   = positionY;
		this.sheepId 	 = sheepId;
	}
	
	public int getMessageId() {
		return messageId;
	}
	
	public void setMessageID(int messageID) {
		this.messageId = messageID;
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
	
	public int getSheepId() {
		return sheepId;
	}
	
	public void setSheepID(int sheepId) {
		this.sheepId = sheepId;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Sheep getSheep()
	{
		return sheep;
	}
	
	public String toString() {
		return "Id: " + messageId + "; Date: " + dateTime + "; Pulse: " +
				pulse + "; Temperature: " + temperature + "; Status: " +
				status + "X: " + positionX + "; Y:" + positionY +
				"; SheepId: " + sheepId;
	}
}
