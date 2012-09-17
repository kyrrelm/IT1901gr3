package test;


import server.*;
public class CommTestServer {
	
	public static void main(String asdasd[])
	{
		SocketServer sockServ = new SocketServer(6667);
		
		sockServ.run();
		
		sockServ.close();
		
	}

}
