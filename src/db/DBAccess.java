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
import java.util.Random;

import map.Constants;


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
			ex.printStackTrace();
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

	//kan noen skrive denne metoden? plizzz
	public static void removeFarm(int FarmId){
		try {
			Statement st = con.createStatement();	
			st.executeUpdate("DELETE FROM Farm WHERE FarmID = '" + FarmId + "'");
			
			
			// Slett alle sauene som tilhørte den gården ELLER sett FarmID til noe rart og unikt, eks: -1
			// -1 nu.
			st.executeUpdate("UPDATE Sheep SET FarmID=-1 WHERE FarmID=" + FarmId);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
	}
	/**
	 * Adds an owner to the database
	 * @author halvor
	 * 
	 * 
	 * @param username
	 * User Name
	 * @param pw
	 * Passsword
	 * @param firstName
	 * First name of owner
	 * @param lastName
	 * Last name of owner
	 * @param tlf
	 * Telephone number of the owner 
	 * @param email
	 * Email adress of the owner
	 * @param secondaryTlf
	 * Telephone number of the secondary contact person
	 * @param secondaryEmail
	 * Email adress of the secondary contact person
	 */
				
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
	
	/**
	 * Adds a farm to the database, requires an owner.
	 * @author halvor
	 * 
	 * @param name
	 * The name of the farm
	 * @param ownerId
	 * The ID of the owner.
	 */
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
	
	/**Adds a sheep to the database.
	 * Note: This method is synchronized because it checks the last sheep added to get back the sheepID (to create a message)
	 * @author halvor
	 * 
	 * 
	 * @param name
	 * The sheep's name or ID Tag
	 * @param birthYear
	 * The year the sheep was born
	 * @param farmID
	 * The farm that the sheep belongs to.
	 * @param ownerID
	 * The owner that the sheep belongs to.
	 */
	public static synchronized void addSheep(String name, int birthYear, int farmID, int ownerID)
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
			
			// finn ut hva sauIDen ble for sauen man akuratt la til!
			ResultSet rs = st.executeQuery("SELECT SheepID FROM Sheep ORDER BY SheepID desc limit 1");
			rs.next();
			int sheepID = rs.getInt(1);
			
			Random r = new Random();
			double positionX = Constants.minLon + (Constants.maxLon - Constants.minLon) * r.nextDouble();
			double positionY = Constants.minLat +  (Constants.maxLat - Constants.minLat) * r.nextDouble();

			// legg til en melding for denne sauenyyyyyyyyyyyyyyy
			java.util.Date date = new java.util.Date();
			java.text.SimpleDateFormat simpleDateFormat = 
					new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = simpleDateFormat.format(date);
			addMessage(75, 35, 0,
					positionX, positionY, sheepID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Adds a message to the database, requires a sheep.
	 * Note: this method is called by addsheep
	 * @author halvor
	 * 
	 * @param pulse
	 * The sheep's pulse.
	 * @param temperature
	 * the sheep's temperature.
	 * @param status
	 * Sheep status, 0 = healthy, 1 = under attack
	 * @param positionX
	 * The Longtitude.
	 * @param positionY
	 * The Latitude.
	 * @param sheepId
	 * The ID of the sheep.
	 */
	public static synchronized Message addMessage(int pulse, int temperature,
			int status, double positionX, double positionY, int sheepId) {
		
		
		// timestamp moved here.
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat simpleDateFormat = 
				new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = simpleDateFormat.format(date);
		
		Message message = null;
		
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
				
				ResultSet resultSet = st.executeQuery(
						"SELECT * FROM Message ORDER BY MessageID DESC LIMIT 1");
				
				
				if(resultSet.last()) {
					String sheepID = resultSet.getString(8);
					message = new Message(Integer.parseInt(resultSet.getString(1)),
							resultSet.getDate(2), 
							Integer.parseInt(resultSet.getString(3)),
							Float.parseFloat(resultSet.getString(4)),
							Integer.parseInt(resultSet.getString(5)),
							Double.parseDouble(resultSet.getString(6)),
							Double.parseDouble(resultSet.getString(7)),
							Integer.parseInt(resultSet.getString(8)),
							getSheepById(Integer.parseInt(sheepID)));
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return message;
	}
	
	
	/**
	 * Here we check to see if the username sent as a parameter is already in
	 *  the database
	 * 
	 * @author Kenneth
	 * @param userName - The username we want to check
	 * @return true if userName is already in the database, false otherwise
	 */
	public static boolean isUsernameTaken(String userName)
	{
		try {
			Statement statement = con.createStatement();
			
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM Owner WHERE UserName = '" + userName + "'");
			int counter = 0;
			
			
			while(resultSet.next()) {
				counter += 1;
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
	
	
	/**
	 * This function checks to see if an email address is already in the
	 *  database. (We check the email addresses for the owners. This is used
	 *  to prevent a user to register again if he is already registered. This
	 *  again means that several owners cannot share an email address). 
	 *  
	 * @author Kenneth
	 * @param emailAddress - The email address we want to check
	 * @return true if email address is already in database, false otherwise
	 */
	public static boolean isEmailAddressTaken(String emailAddress)
	{
		try {
			Statement statement = con.createStatement();
			
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM Owner WHERE PrimaryMail = '" + 
					emailAddress + "'");
			int counter = 0;
			
			
			while(resultSet.next())
			{
				counter += 1;
			}
			
			
			if(counter > 0)
			{
				return true;
			}
			
			
			return false;
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			
			return true;
		}
	}
	
	
	/**
	 * This function checks to see if a sheep name already is taken for a
	 *  specific farm.
	 * 
	 * @author Kenneth
	 * @param sheepName - The sheep name we want to check
	 * @param farmId - The id of the farm where the sheep is
	 * @return true if the farm already has a sheep by the name of sheepName,
	 *  false otherwise
	 */
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
	
	/*Kan hende jeg misforstår, men vil ikke denne metoden kunn returnere siste farm,
	 * selv hvis bonden har flere?
	 * Korrekt, bør fikses - Halvor
	 	* - Tror ikke denne metoden brukes til noe uansett.	 
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
	
	//returnerer alle bondens gårder
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
	public static ArrayList<Sheep> getAllSheepByOwner(int ownerId) {
		try {
			Statement statement = con.createStatement();
			ArrayList<Sheep> sheep = new ArrayList<Sheep>();
			
		
			
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM Sheep WHERE OwnerID = '" + ownerId + "'");
			
			while(resultSet.next()) {
				sheep.add(new Sheep(Integer.parseInt(resultSet.getString(1)), 
						resultSet.getString(2), Integer.parseInt(resultSet.getString(3)),
						Integer.parseInt(resultSet.getString(4)), Integer.parseInt(resultSet.getString(5))));
			}
			
			return sheep;
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
				String sheepID = resultSet.getString(8);
				message = new Message(Integer.parseInt(resultSet.getString(1)),
						resultSet.getDate(2), 
						Integer.parseInt(resultSet.getString(3)),
						Float.parseFloat(resultSet.getString(4)),
						Integer.parseInt(resultSet.getString(5)),
						Double.parseDouble(resultSet.getString(6)),
						Double.parseDouble(resultSet.getString(7)),
						Integer.parseInt(resultSet.getString(8)),
						getSheepById(Integer.parseInt(sheepID)));
			}
			
			return message;
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return null;
		}
	}
	
	/** Returns every message, no longer in use.
	 * 
	 * 
	 * @param OwnerID
	 * The ID of the owner.
	 * @return every message
	 */
	public static ArrayList<Message> getMessagesByOwner(int OwnerID) 
	{
		
		/**
		 * Ensures that it is not possible to simultanously update and receive data
		 * -- See method addMessage for reference.
		 * DEPRECATED
		 * @author halvor
		 */		
		//synchronized (DBAccess.class){
		
			try {
				Statement statement = con.createStatement();
				ArrayList<Message> messages = new ArrayList<Message>();
				
			
				
				ResultSet resultSet = statement.executeQuery("SELECT m.* FROM Message m, Sheep s " +
																"WHERE m.SheepID = s.SheepID " +
																"AND s.OwnerID = " + OwnerID);
				
				while(resultSet.next()) {
					String sheepID = resultSet.getString(8);
					messages.add( new Message(Integer.parseInt(resultSet.getString(1)),
							resultSet.getDate(2), 
							Integer.parseInt(resultSet.getString(3)),
							Float.parseFloat(resultSet.getString(4)),
							Integer.parseInt(resultSet.getString(5)),
							Double.parseDouble(resultSet.getString(6)),
							Double.parseDouble(resultSet.getString(7)),
							Integer.parseInt(resultSet.getString(8)),
							getSheepById(Integer.parseInt(sheepID))));
				}
				
				return messages;
			}
			catch(SQLException exception) {
				exception.printStackTrace();
				
				return null;
			}
		//}
	}
	
	/**Returns every message by first building an arraylist of all sheep belonging to the owner, then getting the last 5 messages of those sheep.
	 * @author halvor
	 * 
	 * @param OwnerID
	 * The owner's ID.
	 * @return Last 5 messages of all sheep belonging to the owner.
	 */
	public static ArrayList<ArrayList<Message>> getLastFiveMessagesByOwner(int OwnerID) 
	{
		
		/**
		 * Ensures that it is not possible to simultanously update and receive data
		 * -- See method addMessage for reference.
		 * @author halvor
		 */		
		
		try {
			Statement statement = con.createStatement();
			ArrayList<ArrayList<Message>> messages = new ArrayList<ArrayList<Message>>();
			
			// finn alle sauene til duden:
			ArrayList<Sheep> sheeple = getSheepByOwnerID(OwnerID);
			
			// iterer over alle sauene
			for (Sheep s: sheeple)
			{
				int SheepID = s.getSheepId();
				
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Message WHERE SheepID = " + SheepID + " ORDER BY MessageID DESC LIMIT 0,5");
				ArrayList<Message> tmp = new ArrayList<Message>();
				while(resultSet.next())
				{
							tmp.add( new Message(Integer.parseInt(resultSet.getString(1)),
							resultSet.getDate(2), 
							Integer.parseInt(resultSet.getString(3)),
							Float.parseFloat(resultSet.getString(4)),
							Integer.parseInt(resultSet.getString(5)),
							Double.parseDouble(resultSet.getString(6)),
							Double.parseDouble(resultSet.getString(7)),
							Integer.parseInt(resultSet.getString(8)),
							s));
				}
				messages.add(tmp);
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
				//In case the database stores a friend's telephone number as a
				// empty String, we would get an error if we tried to convert it to
				// an integer. Therefore we need to check this and handle it if
				// this is the case. Kenneth
				int friendTelephoneNumber = -1;
				String temp = resultSet.getString(8);
				
				
				if(!temp.isEmpty())
				{
					friendTelephoneNumber = Integer.parseInt(temp);
				}
								
				
				owner = new Owner(Integer.parseInt(resultSet.getString(1)),
						resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), 
						Integer.parseInt(resultSet.getString(6)),
						resultSet.getString(7),
						friendTelephoneNumber,
						resultSet.getString(9));					
			}
			
			return owner;
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return null;
		}
	}
	
	/**
	 * Function updates all contactinformation for the owner
	 * 
	 * @author Kenneth
	 * @param username - Username of the owner
	 * @param password - Password for the owner
	 * @param telephone - The owner's new telephonenumber
	 * @param email - The owner's new emailadress
	 * @param friendTelephone - The new telephonenumber for the owner's friend
	 * @param friendEmail - The new emailadress for the owner's friend
	 * @return - Updated Owner-object if update was successful, null otherwise
	 */
	public static Owner updateOwnerContactInformation(String username,
			String password, String telephone, String email,
			String friendTelephone, String friendEmail) {
		
		
		try {
			Statement statement = con.createStatement();
						
			//If friend telephone number is flagged with -1, then this means
			// that the field for this number is empty and we shall update with
			// an empty string
			String friendTelephoneNumber = "";
			
			
			if(Integer.parseInt(friendTelephone) > 0)
			{
				friendTelephoneNumber = friendTelephone;
			}
			
			
			statement.executeUpdate(
					"UPDATE Owner SET PrimaryTLF='" + telephone +
					"', PrimaryMail='" + email +
					"', SecondaryTLF='" + friendTelephoneNumber +
					"', SecondaryMail='" + friendEmail +
					"' WHERE Username='" + username + "' AND Password='" +
					password + "'");
						
			
			return getOwner(username, password);
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return null;
		}
	}
	
	
	/**
	 * Function updates the owner's emailadress in the database
	 * 
	 * @author Kenneth
	 * @param username - Username of the owner
	 * @param password - Password for the owner
	 * @param email - The new emailadress
	 * @return Updated Owner-object if update was successful, null otherwise
	 */
	public static Owner updateOwnerEmail(String username, String password,
			String email) {
		try {
			Statement statement = con.createStatement();
			
			
			//If email is an empty string
			if(email == "") {
				return null;
			}
			
			
			//We update the emailadress
			ResultSet resultSet = statement.executeQuery(
					"UPDATE Owner SET PrimaryMail ='" + email + 
					"' WHERE Username='" + username + "' AND Password='" +
					password + "'");
			
			//We now want to return the owner
			return getOwner(username, password);
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return null;
		}
	}
	
	
	/**
	 * Function updates the owner's private telephonenumber in the database.
	 * 
	 * @author Kenneth
	 * @param username - Username of the owner
	 * @param password - Password for the owner
	 * @param telephone - The new telephonenumber
	 * @return Updated Owner-objekt if update was successful, null otherwise
	 */
	public static Owner updateOwnerTelephone(String username,
			String password, String telephone) {
		try {
			Statement statement = con.createStatement();
			//Owner owner = null;
			
			
			//If telephone contains an empty string
			if(telephone == "") {
				return null;
			}
			
			
			//We update the telephonenumber
			ResultSet resultSet = statement.executeQuery(
					"UPDATE Owner SET PrimaryTLF='" +
					telephone + "' WHERE Username = '" + username +
					"' AND Password='" + password + "'");
			
			//We want to return the owner
			return getOwner(username, password);
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return null;
		}
	}
	
	
	/**
	 * Function updates the emailadress in the database of the owner's
	 *  friend.
	 * 
	 * @author Kenneth
	 * @param username - Username of the owner
	 * @param password - Password for the owner
	 * @param friendEmail - The new emailadress for the friend
	 * @return Updated Owner-object if update was successful, null otherwise
	 */
	public static Owner updateOwnerFriendEmail(String username,
			String password, String friendEmail) {
		try {
			Statement statement = con.createStatement();
			//Owner owner = null;
			
			
			//If telephone contains an empty string
			if(friendEmail == "") {
				return null;
			}
			
			
			//We update the telephonenumber
			ResultSet resultSet = statement.executeQuery(
					"UPDATE Owner SET SecondaryMail='" + friendEmail +
					"' WHERE Username = '" + username + "' AND Password='" +
					password + "'");
			
			//We want to return the owner
			return getOwner(username, password);
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return null;
		}
	}
	
	
	/**
	 * Function updates the telephonenumber in the database of the owner's
	 *  friend.
	 * 
	 * @author Kenneth
	 * @param username - Username of the owner
	 * @param password - Password for the owner
	 * @param friendTelephone - The new telephonenumber for the friend
	 * @return Updated Owner-objekt if update was successful, null otherwise
	 */
	public static Owner updateOwnerFriendTelephone(String username,
			String password, String friendTelephone) {
		try {
			Statement statement = con.createStatement();
			//Owner owner = null;
			
			
			//If telephone contains an empty string
			if(friendTelephone == "") {
				return null;
			}
			
			
			//We update the telephonenumber
			ResultSet resultSet = statement.executeQuery(
					"UPDATE Owner SET SecondaryTLF='" + friendTelephone +
					"' WHERE Username = '" + username + 
					"' AND Password='" + password + "'");
			
			//We want to return the owner
			return getOwner(username, password);
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
	
	public static ArrayList<Sheep> getSheepByOwnerID(int ownerID)
	{
		try {
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(String.format("SELECT * FROM Sheep WHERE OwnerID = %d", ownerID));
			
			ArrayList<Sheep> shp = new ArrayList<Sheep>();
			
			while (rs.next()) 
			{
				shp.add(new Sheep(Integer.parseInt(rs.getString(1)),
						rs.getString(2),
						Integer.parseInt(rs.getString(3).substring(0, 4)),
						Integer.parseInt(rs.getString(4)),
						Integer.parseInt(rs.getString(5)))
						);
				
			}
			
			return shp;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	/**
	 * Henter ut den siste messagen per sheepID
	 * TODO: Finne ut en måte å gjøre dette i et SQL kall istedetfor å hente ALLE beskjedene og så filtrere dem her.
	 * @author halvor
	 */
	public static ArrayList<Message> getLastMessages()
	{
		try {
			Statement statement = con.createStatement();
			ArrayList<Message> messages = new ArrayList<Message>();
			
			// finn alle sauene til duden:
			ArrayList<Sheep> sheeple = getAllSheep();
			
			// iterer over alle sauene
			
			for (Sheep s: sheeple)
			{
				int SheepID = s.getSheepId();
				
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Message WHERE SheepID = " + SheepID + " ORDER BY MessageID DESC LIMIT 0,1");
				
				while(resultSet.next())
				{
					// kun legg til sauer som er levannes
					if (Integer.parseInt(resultSet.getString(5)) == 0)
					{
					messages.add( new Message(Integer.parseInt(resultSet.getString(1)),
							resultSet.getDate(2), 
							Integer.parseInt(resultSet.getString(3)),
							Float.parseFloat(resultSet.getString(4)),
							Integer.parseInt(resultSet.getString(5)),
							Double.parseDouble(resultSet.getString(6)),
							Double.parseDouble(resultSet.getString(7)),
							Integer.parseInt(resultSet.getString(8)),
							s));
					}
				}
				
			}				
							
			return messages;
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return null;
		}
	}
	
	
	/***
	 * Deletes all records in table 'Farm'
	 * 
	 * @author Kenneth
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
	 * 
	 * @author Kenneth
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
	 * 
	 * @author Kenneth
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
	 * 
	 * @author Kenneth
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
	
	
	/**
	 * Funtion removes a sheep based on a sheep id
	 * 
	 * @author Kenneth
	 * @param sheepId - The id of the sheep to remove
	 */
	public static void removeSheep(int sheepId) {
		try {
			Statement statement = con.createStatement();
			
			statement.executeUpdate("DELETE FROM Sheep WHERE SheepID = '" + sheepId + "'");
			
			// også fjern beskjeder ang. den sauen -halvor
			
			statement.executeUpdate("DELETE FROM Message WHERE SheepID = '" + sheepId + "'");
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return;
		}
		
	}
	
	
	public static Owner getOwnerBySheepID(int sheepId)
	{
		try {
			Statement statement = con.createStatement();
			
			ResultSet resultSet = statement.executeQuery(
					"SELECT o.* FROM Owner o, Sheep s WHERE s.SheepID = "+ sheepId +" AND s.OwnerID = o.OwnerID");
			
			Owner owner = null;
			
			
			while(resultSet.next())	{
				//In case the database stores a friend's telephone number as a
				// empty String, we would get an error if we tried to convert it to
				// an integer. Therefore we need to check this and handle it if
				// this is the case. Kenneth
				int friendTelephoneNumber = -1;
				String temp = resultSet.getString(8);
				
				
				if(!temp.isEmpty())
				{
					friendTelephoneNumber = Integer.parseInt(temp);
				}
				
				
				owner = new Owner(Integer.parseInt(resultSet.getString(1)),
						resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), 
						Integer.parseInt(resultSet.getString(6)),
						resultSet.getString(7),
						friendTelephoneNumber,
						resultSet.getString(9));					
			}
			
			return owner;
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			
			return null;
		}
	}
	
}
