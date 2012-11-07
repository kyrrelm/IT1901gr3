package helpclasses;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Message implements Serializable {
	private int messageId;
	private int pulse;
	private double positionX;
	private double positionY;
	private int sheepId;
	private int status;
	private float temperature;
	private Date dateTime;
	private Sheep sheep;
	private boolean alarm;
	
	
	public Message(int messageId, Date dateTime, int pulse, float temperature,
			int status, double positionY, double positionX, int sheepId, Sheep sheep) {
		this.messageId   = messageId;
		this.dateTime    = dateTime;
		this.pulse 		 = pulse;
		this.temperature = temperature;
		this.status 	 = status;
		this.positionX   = positionX;
		this.positionY   = positionY;
		this.sheepId 	 = sheepId;
		this.sheep       = sheep;
		
		// HAX
		if (status == 0)
			this.alarm = false;
		else
			this.alarm = true;
		
	}
	
	public boolean isAlarm() {
		return alarm;
	}

	public void setAlarm(boolean alarm) {
		this.alarm = alarm;
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
	
	public double getPositionX() {
		return positionX;
	}
	
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	
	public double getPositionY() {
		return positionY;
	}
	
	public void setPositionY(double positionY) {
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
	
	public Sheep getSheep()
	{
		return sheep;
	}
	
	public Date getDateTime()
	{
		return dateTime;
	}
	
	/**
	 * @author Kyrre
	 * Uses html to color code Messages, and formate it.
	 */
	public String toString() {
		String color;
		if(this.alarm == true)
			color = "red";
		else
			color = "green";
		return "<html><span style=\"color:"+ color +"\"><b>Message Id: " + messageId + ", Sheep Id: " + sheepId + "</b></span>" +
				"<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Date: " + dateTime + ", Pulse: " +
				pulse + ", Temperature: " + temperature +
				", Position: " +"("+ round(positionX, 2) +", "+ round(positionY, 2) +")<br>&nbsp;</html>";
	}
	/**
	 * @author Kyrre
	 * Uses html to format a String used by the Map pane (javascript)
	 */
	public String toStringMap() {
		return "Id: " + sheepId + "<br>Date: " + dateTime + "<br>Pulse: " +
				pulse + "<br>Temperature: " + temperature + "<br>Under attack: " +
				alarm + "<br>Position: " +"("+ round(positionX, 4) +", "+ round(positionY, 2) +")";
	}
	
	
	
	/**
	 * Increments sheep's movement vector with increment
	 * @param x2 The x value to be added
	 * @param y2 The y value to be added
	 */
	public void setPos(double x2, double y2) { //TODO maybe you're not supposed to increment but rather set? (unlikely)
		/*
		positionX += x2;
		positionY += y2;
		*/
		// currently proof of concept: Sets position directly.
		positionX = x2;
		positionY = y2;
	}
	
	/**
	 * @author Kyrre
	 * @
	 * @param unrounded Float value to be rounded up
	 * @param precision Number of decimals
	 * @return double
	 */
	public static double round(double unrounded, int precision)
	{
	    BigDecimal bd = new BigDecimal(unrounded);
	    BigDecimal rounded = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
	    return rounded.doubleValue();
	}
}
