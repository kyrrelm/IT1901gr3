package client;

import db.*;

public class Client {
	
	public static void main(String asdasdasd[])
	{
		try {
			db.DBAccess.open();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
