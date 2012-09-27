package test;

import helpclasses.CommMessage;

import java.util.ArrayList;
import java.util.Arrays;

import client.*;

public class CommTestClient {
	
	public static void main(String asdasd[])
	{
		
		
		SocketClient sockCli = new SocketClient("localhost", 6667);
		
		sockCli.run();
		
		sockCli.sendMessage(new CommMessage<String>("message", Arrays.asList("param1", "param2", "param3")));
		
		sockCli.close();

		
	}


}
