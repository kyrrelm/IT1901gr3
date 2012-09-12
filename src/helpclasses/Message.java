package helpclasses;

public class Message {
	int messageID;
	//datetime dateTime;
	int pulse;
	float temperature;
	int positionX;
	int positionY;
	int sheepID;
	int status;
	
	public Message (int messageID, int pulse, float temperature, int positionX, int positionY, int sheepID, int status){
		this.messageID = messageID;
		this.pulse = pulse;
		this.temperature = temperature;
		this.positionX = positionX;
		this.positionY = positionY;
		this.sheepID = sheepID;
		this.status = status;
	}
}
