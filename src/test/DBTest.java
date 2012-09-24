/***
 * This class is used for testing
 * 
 * @author Kenneth Pettersen Lund
 */


package test;

import helpclasses.Sheep;

public class DBTest 
{
	public static void main(String args[]) throws InstantiationException,
												  IllegalAccessException
	{

		db.DBAccess.open();
		
		//Delete all records in all tables before generating data
		db.DBAccess.deleteAllFromFarm();
		db.DBAccess.deleteAllFromMessage();
		db.DBAccess.deleteAllFromOwner();
		db.DBAccess.deleteAllFromSheep();
		
		//Generate data for the database
		
		
		/*db.DBAccess.addOwner("Sau", "Hans", "Hansen", "81549300", 
							 "supportyahoo.com", "911", "supportpoliti.no");
		db.DBAccess.addFarm("BestFarm", 1);
		db.DBAccess.addSheep("Beverly", 2010, 1, 1);
		
		Sheep sheep = db.DBAccess.getSheepById(1);
		
		if (sheep != null)
			System.out.println(sheep);*/
		
		
		db.DBAccess.close();
		
	}
}
