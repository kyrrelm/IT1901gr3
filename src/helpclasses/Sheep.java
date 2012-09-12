package helpclasses;

public class Sheep {
	//Vector2 Position;
	int pulse;
	int temperature;
	String ID;
	
	public Sheep(int pulse, int temperature, String ID)
	{
		this.pulse = pulse;
		this.temperature = temperature;
		this.ID = ID;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}
