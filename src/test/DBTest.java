/***
 * This class is used for testing, generating data, deleting contents in 
 *  database
 * 
 * @author Kenneth Pettersen Lund
 */


package test;

import helpclasses.*;
import java.util.Random;

import map.Constants;

import db.DBAccess;


public class DBTest {
	public static void main(String args[]) throws InstantiationException,
			IllegalAccessException {
		
		DBAccess.open();
		
		//Delete all records in all tables before generating data
		DBAccess.deleteAllFromFarm();
		DBAccess.deleteAllFromMessage();
		DBAccess.deleteAllFromOwner();
		DBAccess.deleteAllFromSheep();
		
		
		String[] firstNames = { "Lars", "Hege", "Petter", "Frida", "Morten",
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
				"Krokstad", "Leinum", "Vestvik", "Dybvadsskog", "Matberg",
				"Solsem", "Nordfjord", "Falkfjell", "Matberg", "Selvik",
				"Digre", "Karlsen", "Hallem", "Strand", "Mattingsdal" 
				};
		
		String[] userNames = { "TheJoker", "Ghost", "Dog", "Sheep", "Face",
				"Ship", "Techno", "Spiderman", "Warrior", "Car",  "Batman",
				"Porsche", "Alien", "MrMister", "Fish", "Tank", "Porsche",
				"Grasshopper", "Superman", "Ferrari"
				};
		
		String[] sheepNames = { "Mador", "Tedrick", "Mojo Jojo", "Andreo",
				"Elia", "Engelbertine", "Lynna", "Wilmer", "Kay", "Edmund",
				"Spark", "Joker", "Nikita", "Torn", "Kasandra", "Severin",
				"Herkules", "Bella", "Heo", "Thor"
				};
		
		
		Random generator = new Random();
		
			
		//Generate data for the database
		for(int i = 0; i <= 6; i++) {	//Generate 7 owners
			//Generate data for owner
			boolean hasMiddleName    = generator.nextBoolean();
			int 	nFarms		     = generator.nextInt(2);
			String  username		 = userNames[generator.nextInt(20)];
			String 	password	     = "Sheep";
			String  firstName        = firstNames[generator.nextInt(20)];
			String  middleName       = "";
			String 	lastName         = lastNames[generator.nextInt(20)];
			String  friendFirstName   = firstNames[generator.nextInt(20)];
			String  friendLastName    = lastNames[generator.nextInt(20)];
			String  phoneNumber	     = "";
			String  friendPhoneNumber = "";
			
			
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
			
			
			//We add userName with the first 4 number from the phoneNumber
			username = username + phoneNumber.substring(0, 4);
			
			//We allow no duplicate copy of userName in database
			boolean isUsernameTaken = DBAccess.isUsernameTaken(username);	
			
			
			while(isUsernameTaken == true) {
				username = userNames[generator.nextInt(20)];
				username = username + phoneNumber.substring(0, 4);
				isUsernameTaken = DBAccess.isUsernameTaken(username);
			}
						
			
			//We add owner to database
			DBAccess.addOwner(username, password, firstName + middleName,
					lastName, phoneNumber, email, friendPhoneNumber, 
					friendEmail);
			//Get ownerId
			Owner owner = DBAccess.getOwner(username, password);
			
			Sheep sheep   = null;
		
			
			//Generate data for farm
			for(int k = 0; k <= nFarms; k++) {
				String farmName = owner.getLastName() + " gaard";
				
				
				if(nFarms > 0)
					farmName = owner.getLastName() + " gaard " + (k + 1);
				
				
				DBAccess.addFarm(farmName, owner.getOwnerId());
				
				//Genererate sheep for farm
				boolean hasName  = false;
				int nSheep       = generator.nextInt(15);
				int indexNo		 = 0;
				int birthYear    = 2010;
				String sheepName = "";
				Farm farm        = DBAccess.getFarm(owner.getOwnerId());
				
				
				for(int l = 0; l <= nSheep; l++) {
					hasName    = generator.nextBoolean();
					birthYear  = 2005 + generator.nextInt(8);
					indexNo    = generator.nextInt(20);
					sheepName = "";
					
					
					if(hasName == true) {				
						if(DBAccess.isSheepNameTaken(
								sheepNames[indexNo],
								farm.getFarmId()) == false) {				
							sheepName = sheepNames[indexNo];
						}
					}
					
					
					DBAccess.addSheep(sheepName, birthYear,
							farm.getFarmId(), owner.getOwnerId());
					sheep = DBAccess.getLastAddedSheep();
					
					/* det her blir gjort i DBAccess.addsheep!
					
					java.util.Date date = new java.util.Date();
					java.text.SimpleDateFormat simpleDateFormat = 
						new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String currentTime = simpleDateFormat.format(date);
					DBAccess.addMessage(currentTime, 75, 35, 0,
							positionX, positionY, sheep.getSheepId());
							*/		
				}
			}
		}
			
		System.out.println("Data has been generated.");

		DBAccess.close();	
	}
}
