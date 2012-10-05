/**
 * @author 
 * @author Kenneth Pettersen Lund
 */


package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import helpclasses.*;

public class DBAccess {

	public static Connection con;
	
	//Parameter url
	public static void open() throws InstantiationException, 
									 IllegalAccessException 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://mysql.stud.ntnu.no/halvobj_saupro12g3";
			String user = "halvobj_sau12";
			String pw = "sau";
			con = DriverManager.getConnection(url,user,pw);
			System.out.println("Tilkoblingen fungerte.");
		} 
		catch (SQLException ex) 
		{
			System.out.println("Tilkobling feilet: "+ ex.getMessage());
		}
		catch (ClassNotFoundException ex) 
		{
			System.out.println("Feilet under driverlasting: "+ ex.getMessage());
		} 
	}
	
	public static void close()
	{
		try 
		{
			if (con !=  null) con.close();
		} 
		catch (SQLException ex)
		{
			System.out.println("Epic fail: "+ ex.getMessage());
		}
	}

	public static void addOwner(String username, String pw, String firstName,
			String lastName, String tlf, String email, String secondaryTlf,
			String secondaryEmail) {
		try {
			Statement st = con.createStatement();
			/*    FOR TESTING:
			String s = "INSERT INTO Owner(Password, FirstName, LastName, PrimaryTLF, PrimaryMail, SecondaryTLF, SecondaryMail) VALUES " + String.format("(\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")",  pw, name, tlf, email, secondaryTlf, secondaryEmail); 
			System.out.println(s);
			*/
			st.executeUpdate("INSERT INTO Owner(Username, Password, FirstName, LastName, PrimaryTLF, PrimaryMail, SecondaryTLF, SecondaryMail) VALUES "
			+ String.format("(\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")",
			username, pw, firstName, lastName, tlf, email, secondaryTlf, secondaryEmail));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	
	public static void addFarm(String name, int ownerId)
	{
		try {
			Statement statement = con.createStatement();
			
			/*    FOR TESTING:
			String s = 
			System.out.println(s);
			*/
			statement.executeUpdate("INSERT INTO Farm(Name, OwnerID) VALUES " +
					String.format("(\"%s\", \"%d\")", name, ownerId));
			
			
			
			/*st.executeUpdate("INSERT INTO Farm(Name, OwnerID) VALUES " 
					+ String.format("(\"%s\", \"%s\")",  "1830", 
							String.valueOf(ownerID)));*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	public static void addSheep(String name, int birthYear, int farmID, int ownerID)
	{
		
		System.out.println(name);
		
		try {
			Statement st = con.createStatement();
		
			/*    FOR TESTING:
			String s = 
			System.out.println(s);
			*/
			st.executeUpdate("INSERT INTO Sheep(Name, BirthYear, FarmID, OwnerID) VALUES "
				+ String.format("(\"%s\", \"%s\", \"%s\", \"%s\")",
					/*"1941",*/ name, String.valueOf(birthYear),
					String.valueOf(farmID), String.valueOf(ownerID)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	public static void addMessage(String dateTime, int pulse, int temperature,
			int status, int positionX, int positionY, int sheepId) {
		
		try {
			Statement st = con.createStatement();
			
			
			
			
			st.executeUpdate("INSERT INTO Message(DateTime, Pulse," +
					" Temperature, Status, PositionX, PositionY, SheepID) " +
					"VALUES" + String.format("(\"%s\", \"%s\", \"%s\"," +
							" \"%s\", \"%s\", \"%s\", \"%s\")",
					dateTime, String.valueOf(pulse), 
					String.valueOf(temperature), String.valueOf(status), 
					String.valueOf(positionX), String.valueOf(positionY),
					String.valueOf(sheepId)));
		}
		catch(SQLException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public static boolean isUsernameTaken(String userName) {
		try {
			Statement statement = con.createStatement();
			
			ResultSet resultSet = statement.executeQuery(
					"SELECT * From Owner WHERE UserName = '" + userName + "'");
			int counter = 0;
			
			
			while(resultSet.next()) {
				counter = counter + 1;
			}
			
			
			if(counter > 0) {
				return true;
			}
			
			
			return false;
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return true;
		}
	}
	
	public static boolean isSheepNameTaken(String sheepName, int farmId) {
		try {
			Statement statement = con.createStatement();
			
			ResultSet resultSet = statement.executeQuery(
					"Select Name FROM Sheep WHERE FarmID = '" + farmId + "'");
			
			while(resultSet.next()) {
				if(resultSet.getString(1) == sheepName) {
					return true;
				}
			}
			
		return false;	
		}
		catch(SQLException exception) {
			exception.printStackTrace();
						
			return false;
		}
	}
	
	/*Kan hende jeg misforst�r, men vil ikke denne metoden kunn returnere siste farm,
	 * selv hvis bonden har flere?
	 */
	
	public static Farm getFarm(int ownerId) {
		try {
			Statement statement = con.createStatement();
			Farm farm			= null;
			//We want to get the FarmID and return it
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM Farm WHERE OwnerID = '" + ownerId + "'");
								
			
			//The FarmID we are interested in will be the last added in database
			while(resultSet.next()) {
				farm = new Farm(Integer.parseInt(resultSet.getString(1)),
						resultSet.getString(2),
						Integer.parseInt(resultSet.getString(3)));
			}
			
			
		return farm;
		}
		catch(SQLException exception) {
			exception.printStackTrace();
		
			return null;
		}
	}
	
	//returnerer alle bondens g�rder
	public static ArrayList<Farm> getFarmsByOwner(int ownerId) {
		try {
			Statement statement = con.createStatement();
			ArrayList<Farm> farms = new ArrayList<Farm>();
			
		
			
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM Farm WHERE OwnerID = '" + ownerId + "'");
			
			while(resultSet.next()) {
				farms.add(new Farm(Integer.parseInt(resultSet.getString(1)),
						resultSet.getString(2),
						Integer.parseInt(resultSet.getString(3))));
			}
			
			return farms;
		}
		catch(SQLException exception) {
			exception.printStackTrace();
		
			return null;
		}
	}
	public static Message getMessage(int messageId) {
		try {
			Statement statement = con.createStatement();
			Message message	  	  = null;
			
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM Message WHERE MessageID= '" + messageId +
					"'");	
			
			
			if(resultSet.last()) {
				message = new Message(Integer.parseInt(resultSet.getString(1)),
						resultSet.getDate(2), 
						Integer.parseInt(resultSet.getString(3)),
						Float.parseFloat(resultSet.getString(4)),
						Integer.parseInt(resultSet.getString(5)),
						Integer.parseInt(resultSet.getString(6)),
						Integer.parseInt(resultSet.getString(7)),
						Integer.parseInt(resultSet.getString(8)));
			}
			
			return message;
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return null;
		}
	}
	
	public static ArrayList<Message> getMessagesByOwner(int OwnerID) {
		try {
			Statement statement = con.createStatement();
			ArrayList<Message> messages = new ArrayList<Message>();
			
		
			
			ResultSet resultSet = statement.executeQuery("SELECT m.* FROM Message m, Sheep s " +
															"WHERE m.SheepID = s.SheepID " +
															"AND s.OwnerID = " + OwnerID);
			
			while(resultSet.next()) {
				messages.add( new Message(Integer.parseInt(resultSet.getString(1)),
						resultSet.getDate(2), 
						Integer.parseInt(resultSet.getString(3)),
						Float.parseFloat(resultSet.getString(4)),
						Integer.parseInt(resultSet.getString(5)),
						Integer.parseInt(resultSet.getString(6)),
						Integer.parseInt(resultSet.getString(7)),
						Integer.parseInt(resultSet.getString(8))) 
				);
			}
			
			return messages;
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return null;
		}
	}
	
	public static Owner getOwner(String username, String password) {
		try {
			Statement statement = con.createStatement();
			
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM Owner WHERE Username = '" + username +
					"' AND Password = '" + password + "'"
					);
			
			Owner owner = null;
			
			
			while(resultSet.next())	{
				owner = new Owner(Integer.parseInt(resultSet.getString(1)),
						resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), 
						Integer.parseInt(resultSet.getString(6)),
						resultSet.getString(7),
						Integer.parseInt(resultSet.getString(8)),
						resultSet.getString(9));						
			}
			
			return owner;
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return null;
		}
	}
	
	
	public static Sheep getLastAddedSheep() {
		try {
			Statement statement = con.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Sheep");
			
			Sheep sheep = null;
			
			
			if(resultSet.last()) {
				sheep = new Sheep(Integer.parseInt(resultSet.getString(1)),
						resultSet.getString(2),
						Integer.parseInt(resultSet.getString(3)),
						Integer.parseInt(resultSet.getString(4)),
						Integer.parseInt(resultSet.getString(5)));
			}
				
			
			return sheep;
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return null;
		}
	}
	
	
	public static Sheep getSheepById(int id)
	{
		try {
			Statement st = con.createStatement();
			/*    FOR TESTING:
			String s = 
			System.out.println(s);
			*/
							// merk: query
			ResultSet rs = st.executeQuery(String.format("SELECT * FROM Sheep WHERE SheepID = %d", id));

			
			// Som eksempel: itererer over alle resultatene, dette er bare et eksempel i getSheepByID fordi sheepID er unik for hver sau!
			// hvis en skulle finne alle sauene som tilh�rer en spesiell bonde (eller bare alle sauene totalt) er det som under en burde bruke
			
			Sheep shp = null;
			
			while (rs.next()) // sheepID, birthYear, farmID, ownerID
			{												        // year har fucked format, burde bytte til INT i databasen...
			/*	shp = new Sheep(Integer.parseInt(rs.getString(1)),
						rs.getString(2),
						Integer.parseInt(rs.getString(3).substring(0, 4)),
						Integer.parseInt(rs.getString(3)),
						Integer.parseInt(rs.getString(4)));
			*/
				shp = new Sheep(Integer.parseInt(rs.getString(1)),
						rs.getString(2),
						Integer.parseInt(rs.getString(3).substring(0, 4)),
						Integer.parseInt(rs.getString(4)),
						Integer.parseInt(rs.getString(5)));
				
			}
			
			return shp;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Henter ut alle sauene
	 * @return ArrayList<Sheep> som rommer alle sauene
	 */
	public static ArrayList<Sheep> getAllSheep()
	{
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Sheep");
			Sheep shp = null;
			ArrayList<Sheep> sheep = new ArrayList<Sheep>();
			
			while (rs.next()) // sheepID, birthYear, farmID, ownerID
			{												        // year har fucked format, burde bytte til INT i databasen...
				shp = new Sheep(Integer.parseInt(rs.getString(1)),
						rs.getString(2),
						Integer.parseInt(rs.getString(3).substring(0, 4)),
						Integer.parseInt(rs.getString(4)),
						Integer.parseInt(rs.getString(5)));
				sheep.add(shp);
			}
			
			return sheep;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void updateAllSheep(ArrayList<Sheep> sheep)
	{
		//og her vil jeg at DB skal oppdatere alle sau-elementene
		//dette brukes hovedsakelig med simulation
		//dette vil se slik ut antar jeg
		
		/*
		for(Sheep s: sheep)
		{
			/*
		 * UPDATE table_name SET column_name1 osv. 
		 
			addMessage(dateTime, s.getPulse(), s.getTemp(), s.getAttacked(), s.getX(), s.getY(), s.getSheepId());
		}*/
		
		//Hvis dette ikke blir gjort riktig kan det hende at alle sauene blir erstattet med feil verdier
	}
	
	/***
	 * Deletes all records in table 'Farm'
	 */
	public static void deleteAllFromFarm() {
		try {
			Statement statement = con.createStatement();
			
			statement.executeUpdate("DELETE FROM Farm");
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return;
		}
		
		System.out.println("All records deleted from table Farm.");
	}	
	
	/***
	 * Deletes all records in table 'Message'
	 */
	public static void deleteAllFromMessage() {
		try {
			Statement statement = con.createStatement();
			
			statement.executeUpdate("DELETE FROM Message");
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return;
		}
		
		System.out.println("All records deleted from table Message.");
	}
	
	/***
	 * Deletes all records in table 'Owner'
	 */
	public static void deleteAllFromOwner() {
		try {
			Statement statement = con.createStatement();
			
			statement.executeUpdate("DELETE FROM Owner");
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return;
		}
		
		System.out.println("All records deleted from table Owner.");
	}
	
	/***
	 * Deletes all records in table 'Sheep'
	 */
	public static void deleteAllFromSheep() {
		try {
			Statement statement = con.createStatement();
			
			statement.executeUpdate("DELETE FROM Sheep");
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return;
		}
		
		System.out.println("All records deleted from table Sheep.");
	}

}