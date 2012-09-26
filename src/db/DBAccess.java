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


import helpclasses.*;

public class DBAccess {

	static Connection con;
	
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

	public static void addOwner(String pw, String firstName, String lastName,
								String tlf, String email, String secondaryTlf,
								String secondaryEmail)
	{
		
		try {
			Statement st = con.createStatement();
			/*    FOR TESTING:
			String s = "INSERT INTO Owner(Password, FirstName, LastName, PrimaryTLF, PrimaryMail, SecondaryTLF, SecondaryMail) VALUES " + String.format("(\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")",  pw, name, tlf, email, secondaryTlf, secondaryEmail); 
			System.out.println(s);
			*/
			st.executeUpdate("INSERT INTO Owner(Password, FirstName, LastName, PrimaryTLF, PrimaryMail, SecondaryTLF, SecondaryMail) VALUES "
			+ String.format("(\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")",
			pw, firstName, lastName, tlf, email, secondaryTlf, secondaryEmail));
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
	
	public static void addMessage(int dateTime, int pulse, int temperature,
			String status, int positionX, int positionY, int sheepId) {
		
		try {
			Statement st = con.createStatement();
			
			st.executeUpdate("INSERT INTO Message(DateTime, Pulse," +
					" Temperature, Status, PositionX, PositionY, SheepID) " +
					"VALUES" + String.format("(\"%s\", \"%s\", \"%s\"," +
							" \"s%\", \"s%\", \"s%\", \"s%\")",
					String.valueOf(dateTime), String.valueOf(pulse), 
					String.valueOf(temperature), status, 
					String.valueOf(positionX), String.valueOf(positionY),
					String.valueOf(sheepId)));
		}
		catch(SQLException e) {
			e.printStackTrace();
			return;
		}
	}
	
	
	public static Owner getOwner(String lastName, String phoneNumber) {
		try {
			Statement statement = con.createStatement();
			
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM Owner WHERE LastName = '" + lastName +
					"' AND PrimaryTLF = '" + phoneNumber + "'"
					);
			
			Owner owner = null;
			
			
			while(resultSet.next())	{
				owner = new Owner(Integer.parseInt(resultSet.getString(1)),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), 
						Integer.parseInt(resultSet.getString(5)),
						resultSet.getString(6),
						Integer.parseInt(resultSet.getString(7)),
						resultSet.getString(8));						
			}
			
			return owner;
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
			// hvis en skulle finne alle sauene som tilhører en spesiell bonde (eller bare alle sauene totalt) er det som under en burde bruke
			
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