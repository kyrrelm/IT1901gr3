package helpclasses;

public class Sheep {
	//Vector2 Position;
	int pulse;
	int temperature;
	int ID;
	
	public Sheep(int pulse, int temperature, int ID)
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

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
