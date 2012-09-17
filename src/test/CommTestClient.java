package test;

import client.*;

public class CommTestClient {
	
	public static void main(String asdasd[])
	{
		
		
		SocketClient sockCli = new SocketClient("localhost", 6667);
		
		sockCli.run();
		
		sockCli.sendMessage("Test123");
		
		sockCli.close();

		
	}


}
