package server;

import helpclasses.CommMessage;
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
		if (msg.getMessageName().equals("Login"))
		{
			
			String usr = (String) params.get(0);
			String pwd = (String) params.get(1);		
			
			Owner own = DBAccess.getOwner(usr, pwd);
			
			if (own != null) // inloggingen fungerte
			{
				st.setLoggedIn(true);
				
				ArrayList<Owner> tempArr = new ArrayList<Owner>();
				tempArr.add(own);
				return new CommMessage<Owner>("LoginSuccessfull", tempArr);
			}
			else // ikke fungerte
				return new CommMessage<String>("LoginFailed", null);
			
		}
		
		// resten av metodene krever at det er en bruker som er innlogget
		if (!st.getLoggedIn())
			return new CommMessage<String>("NotLoggedIn", null);
		
		/***
		 * @author HalvorGB
		 * @params A Sheep
		 */
		if (msg.getMessageName().equals("addSheep"))
		{
			Sheep shp = (Sheep) params.get(0);
			DBAccess.addSheep(shp.getName(), shp.getBirthYear(), shp.getFarmId(), shp.getOwnerId());
			
			// no reply
			return null;
		}
		
		/***
		 * @author HalvorGB
		 * @params An Owner
		 */
		if (msg.getMessageName().equals("getMessages"))
		{
			ArrayList<Message> Msgs = DBAccess.getMessagesByOwner(((Owner) params.get(0)).getOwnerId());
			return new CommMessage<Message>("Messages", Msgs);
		}
		return null;
		
	}

}
