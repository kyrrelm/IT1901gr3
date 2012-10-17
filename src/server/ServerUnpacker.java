package server;

import helpclasses.CommEnum;
import helpclasses.CommMessage;
import helpclasses.Farm;
import helpclasses.Message;
import helpclasses.Owner;
import helpclasses.Sheep;

import java.util.ArrayList;

import db.DBAccess;

public class ServerUnpacker {
	
	public static synchronized CommMessage<?> unpackServerMessage(CommMessage<?> msg, ServerThread st)
	{
		
		ArrayList<?> params = msg.getParamList();
		
		/***
		 * @author HalvorGB
		 * @params String username, String password
		 */
		if (msg.getMessageName() == CommEnum.LOGIN)
		{
			
			String usr = (String) params.get(0);
			String pwd = (String) params.get(1);		
			
			Owner own = DBAccess.getOwner(usr, pwd);
			
			if (!(own != null && (Server.loggedInClients.contains(own)))) // inloggingen fungerte
			{
				//Hva gj�r denne? Hilsen Kyrre :)
				st.setLoggedIn(true);
				Server.loggedInClients.add(own);
				st.setOwner(own);
				
				ArrayList<Owner> tempArr = new ArrayList<Owner>();
				tempArr.add(own);
				return new CommMessage<Owner>(CommEnum.LOGINSUCCESSFUL, tempArr);
			}
			else // ikke fungerte
				return new CommMessage<String>(CommEnum.LOGINFAILED, null);
			
		}
		
		// resten av metodene krever at brukeren er logget inn i gitt tr�d.
		if (!st.getLoggedIn())
			return new CommMessage<String>(CommEnum.NOTLOGGEDIN, null);
		
		/***
		 * @author HalvorGB
		 * @params A Sheep
		 */
		if (msg.getMessageName() == CommEnum.ADDSHEEP)
		{
			Sheep shp = (Sheep) params.get(0);
			DBAccess.addSheep(shp.getName(), shp.getBirthYear(), shp.getFarmId(), shp.getOwnerId());
			

			// return generic success message (the client waits for an answer, one must be sent)
			return new CommMessage<String>(CommEnum.SUCCESS, null);
		}
		if (msg.getMessageName() == CommEnum.REMOVESHEEP)
		{
			Sheep sheep = (Sheep) params.get(0);
			DBAccess.removeSheep(sheep.getSheepId());
			return new CommMessage<Sheep>(CommEnum.SUCCESS, null);
		}
		
		/***
		 * @author HalvorGB
		 * @params An Owner
		 */
		if (msg.getMessageName() == CommEnum.GETMESSAGES)
		{
			ArrayList<Message> Msgs = DBAccess.getLastFiveMessagesByOwner(st.getOwner().getOwnerId());
            System.out.println(st.getOwner().getOwnerId());
            System.out.println(Msgs.size());
			return new CommMessage<Message>(CommEnum.MESSAGESREPLY, Msgs);
		}
		
		if (msg.getMessageName() == CommEnum.GETFARMS)
		{
			ArrayList<Farm> Msgs = DBAccess.getFarmsByOwner(st.getOwner().getOwnerId());
			return new CommMessage<Farm>(CommEnum.FARMSREPLY, Msgs);
		}
		if (msg.getMessageName() == CommEnum.REMOVEFARM)
		{
			Farm farm = (Farm) params.get(0);
			DBAccess.removeFarm(farm.getFarmId());
			return new CommMessage<Farm>(CommEnum.SUCCESS, null);
		}
		if (msg.getMessageName() == CommEnum.ADDFARM)
		{
			Farm farm = (Farm) params.get(0);
			DBAccess.addFarm(farm.getName(), farm.getOwnerId());
			
			ArrayList<Farm> Msgs = DBAccess.getFarmsByOwner(st.getOwner().getOwnerId());
			return new CommMessage<Farm>(CommEnum.FARMSREPLY, Msgs);
		}
		
		/**
		 * Here we call the relevant function in DBAccess.java. This handle the
		 *  updating of the contact information in the database for the owner.
		 *  It updates PrimaryTLF, PrimaryMail, SecondaryTLF and SecondaryMail 
		 */
/*		if(msg.getMessageName() == CommEnum.UPDATECONTACTINFORMATION) {
			Owner owner = (Owner) params.get(0);
			
			DBAccess.updateOwnerContactInformation(
					owner.getUsername(), owner.getPassword(),
					String.valueOf(owner.getPrimaryTLF()),
					owner.getPrimaryMail(),
					String.valueOf(owner.getSecondaryTLF()),
					owner.getSecondaryMail());
			
			return new CommMessage<Owner>(CommEnum.SUCCESS, null);
	}
*/		
		return null;
		
	}

}
