package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import helpclasses.*;

public class DBAccess {

	static Connection con;
	
	public static void open() throws InstantiationException, IllegalAccessException //Parameter url
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
			System.out.println("Tilkobling feilet: "+ex.getMessage());
		}
		catch (ClassNotFoundException ex) 
		{
			System.out.println("Feilet under driverlasting: "+ex.getMessage());
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
			System.out.println("Epic fail: "+ex.getMessage());
		}
	}

	public static void addOwner(String pw, String name, String tlf, String email, String secondaryTlf, String secondaryEmail)
	{
		
		try {
			Statement st = con.createStatement();
			/*    FOR TESTING:
			String s = "INSERT INTO Owner(Password, Name, PrimaryTLF, PrimaryMail, SecondaryTLF, SecondaryMail) VALUES " + String.format("(\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")",  pw, name, tlf, email, secondaryTlf, secondaryEmail); 
			System.out.println(s);
			*/
			st.executeUpdate("INSERT INTO Owner(Password, Name, PrimaryTLF, PrimaryMail, SecondaryTLF, SecondaryMail) VALUES " + String.format("(\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")",  pw, name, tlf, email, secondaryTlf, secondaryEmail));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	public static void addFarm(String Name, int ownerID)
	{
		try {
			Statement st = con.createStatement();
			/*    FOR TESTING:
			String s = 
			System.out.println(s);
			*/
			st.executeUpdate("INSERT INTO Farm(Name, OwnerID) VALUES " + String.format("(\"%s\", \"%s\")",  "1830", String.valueOf(ownerID)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	public static void addSheep(int farmID, int ownerID)
	{
		try {
			Statement st = con.createStatement();
			/*    FOR TESTING:
			String s = 
			System.out.println(s);
			*/
			st.executeUpdate("INSERT INTO Sheep(BirthYear, FarmID, OwnerID) VALUES " + String.format("(\"%s\", \"%s\", \"%s\")",  "1941", String.valueOf(farmID), String.valueOf(ownerID)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	public static void addMessage()
	{
		// TODO: samme måte som over!
		return;
	}
	
	public static Sheep getSheepByID(int id)
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
				shp = new Sheep( Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2).substring(0, 4)), Integer.parseInt(rs.getString(3)), Integer.parseInt(rs.getString(4)));
				
			}
			return shp;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


}