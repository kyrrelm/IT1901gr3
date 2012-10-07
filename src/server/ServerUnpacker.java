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
			
			if (own != null) // inloggingen fungerte
			{
				//Hva gjør denne? Hilsen Kyrre :)
				st.setLoggedIn(true);
				
				ArrayList<Owner> tempArr = new ArrayList<Owner>();
				tempArr.add(own);
				return new CommMessage<Owner>(CommEnum.LOGINSUCCESSFUL, tempArr);
			}
			else // ikke fungerte
				return new CommMessage<String>(CommEnum.LOGINFAILED, null);
			
		}
		
		// resten av metodene krever at brukeren er logget inn i gitt tråd.
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
		
		/***
		 * @author HalvorGB
		 * @params An Owner
		 */
		if (msg.getMessageName() == CommEnum.GETMESSAGES)
		{
			ArrayList<Message> Msgs = DBAccess.getMessagesByOwner(((Owner) params.get(0)).getOwnerId());
			return new CommMessage<Message>(CommEnum.MESSAGESREPLY, Msgs);
		}
		
		if (msg.getMessageName() == CommEnum.GETFARMS)
		{
			ArrayList<Farm> Msgs = DBAccess.getFarmsByOwner(((Owner) params.get(0)).getOwnerId());
			return new CommMessage<Farm>(CommEnum.FARMSREPLY, Msgs);
		}
		if (msg.getMessageName() == CommEnum.REMOVEFARM)
		{
			Farm farm = (Farm) params.get(0);
			DBAccess.removeFarm(farm.getFarmId());
			return new CommMessage<Farm>(CommEnum.SUCCESS, null);
		}
		return null;
		
	}

}
