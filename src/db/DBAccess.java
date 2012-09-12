package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		finally 
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
	}
	
	void registerOwner(String pw, String tlf, String email, String secondaryTlf, String secondaryEmail)
	{
		// INSERT INTO OWNER PWPWPWPWPPWPWPWPPW
		// Lag ny verdi i table Owner, med autoID
		return;
	}
	
	Sheep getSheepByID(int id)
	{
		// SELECT * FROM <sheep>y
		//Sheep shp = new Sheep(...)
		//return Sheep();
		return null;
	}
	
	


}