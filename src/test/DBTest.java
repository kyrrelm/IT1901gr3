package test;

import helpclasses.Sheep;

public class DBTest 
{
	public static void main(String asdasdasd[]) throws InstantiationException, IllegalAccessException
	{

		db.DBAccess.open();
		
		db.DBAccess.registerOwner("Sau", "TestBruker55555", "81549300", "supportyahoo.com", "911", "supportpoliti.no");
		db.DBAccess.addFarm("BestFarm", 1);
		db.DBAccess.addSheep(1,1);
		
		Sheep sp = db.DBAccess.getSheepByID(1);
		
		if (sp != null)
			System.out.println(String.valueOf(sp.getBirthYear()));
		
		
		db.DBAccess.close();
		
	}
}
