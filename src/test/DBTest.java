/***
 * This class is used for testing, generating data
 * 
 * @author Kenneth Pettersen Lund
 */


package test;

import helpclasses.*;
import java.util.Random;


public class DBTest {
	public static void main(String args[]) throws InstantiationException,
												  IllegalAccessException {
/*		String[] firstNames = { "Lars", "Hege", "Petter", "Frida", "Morten",
				"Kristine", "Ole", "Kari", "Espen", "Hanne", "Harry", "Ingrid",
				"Arne", "Amalie", "Thomas", "Heidi", "Roger", "Marte",
				"Erlend", "Trine"
				};
		
		String[] middleNames = { "Haugan", "Thome", "Skrove", "Lien", "Dahle",
				"Schei", "Veimo", "Hofstad", "Hynne", "Bostad", "Elverum",
				"Musum", "Ramberg", "Forbord", "Indahl", "Myhr", "Bakken",
				"Svendsen", "Dahling", "Schiefloe"
				};
		
		String[] lastNames  = { "Larsen", "Evensen", "Lie", "Wold", "Sandnes",
				"Krokstad", "Leinum", "Vestvik", "Dybvadsskog", "Matberg,",
				"Solsem", "Nordfjord", "Falkfjell", "Matberg", "Selvik",
				"Digre", "Karlsen", "Hallem", "Strand", "Mattingsdal" 
				};
		
		String[] sheepNames = { "Mador", "Tedrick", "Mojo Jojo", "Andreo",
				"Elia", "Engelbertine", "Lynna", "Wilmer", "Kay", "Edmund",
				"Spark", "Joker", "Nikita", "Torn", "Kasandra", "Severin",
				"Herkules", "Bella", "Heo", "Thor"
				};
		
		
		Random generator = new Random();
		db.DBAccess.open();
		
		
		//Generate data for the database
		for(int i = 0; i < 1; i++) {	//Generate 75 owners
			//Generate data for owner
			boolean hasMiddleName    = generator.nextBoolean();
			int 	nFarms		     = generator.nextInt(2) + 1;
			String  password	     = "Sheep";
			String 	firstName        = firstNames[generator.nextInt(20)];
			String  middleName       = "";
			String 	lastName         = lastNames[generator.nextInt(20)];
			String friendFirstName   = firstNames[generator.nextInt(20)];
			String friendLastName    = lastNames[generator.nextInt(20)];
			String phoneNumber	     = "";
			String friendPhoneNumber = "";
			
			
			if(hasMiddleName == true) {
				middleName = " " + middleNames[generator.nextInt(20)];
			}
			
			
			String email 	   = firstName.toLowerCase() + 
					middleName.trim().toLowerCase() + lastName.toLowerCase() +
					"@ntnu.no";
			String friendEmail = friendFirstName.trim().toLowerCase() +
					friendLastName.toLowerCase() + "@ntnu.no";
			
			
			//Generate phone numbers
			for(int j = 0; j < 8; j++) {
				phoneNumber       = phoneNumber + generator.nextInt(10);
				friendPhoneNumber = friendPhoneNumber + generator.nextInt(10);
			}
			
			
			db.DBAccess.addOwner(password, firstName + middleName, lastName,
					phoneNumber, email, friendPhoneNumber, friendEmail);
			//Get ownerId
			Owner owner = db.DBAccess.getOwner(lastName, phoneNumber);
			
			System.out.println(owner.toString());
		
			//Generate data for farm
			for(int k = 0; k < nFarms; k++) {
				db.DBAccess.addFarm(owner.getLastName() + " gaard", owner.getOwnerID());
				
				
				//Genererate sheep for farm
				boolean hasName = false;
				int nSheep      = generator.nextInt(50) + 1;
				Farm farm       = getFarm();
				
				
				for(int l = 0; l < nSheep; l++) {
					hasName = generator.nextBoolean();
					
					
				}
			}
		}
			
		
*/		
		
		
		//Delete all records in all tables before generating data
/*		db.DBAccess.deleteAllFromFarm();
		db.DBAccess.deleteAllFromMessage();
		db.DBAccess.deleteAllFromOwner();
		db.DBAccess.deleteAllFromSheep();
*/				
		
/*		db.DBAccess.addOwner("Sau", "Hans", "Hansen", "81549300", 
							 "supportyahoo.com", "911", "supportpoliti.no");
		db.DBAccess.addFarm("BestFarm", 1);
		db.DBAccess.addSheep("Beverly", 2010, 1, 1);
		
		Sheep sheep = db.DBAccess.getSheepById(1);
		
		if (sheep != null)
			System.out.println(sheep);
*/		
		
		db.DBAccess.close();	
	}
}
