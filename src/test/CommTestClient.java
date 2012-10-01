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
		ArrayList<String> loginInfo = new ArrayList<String>();
		loginInfo.add("farmerboi98");
		loginInfo.add("sau4lyf");
		
		
		sockCli.sendMessage(new CommMessage<String>("Login", loginInfo));
		
		while(true)
		{
			continue;
		}
		//sockCli.close();

		
	}


}
