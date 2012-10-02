package test;


import server.*;
public class CommTestServer {
	
	public static void main(String asdasd[]) throws InstantiationException, IllegalAccessException
	{
		// open DB connection!
		db.DBAccess.open();
		
		SocketServer sockServ = new SocketServer(6667);
		
		sockServ.run();
		
		sockServ.close();
		
		db.DBAccess.close();
		
	}

}
