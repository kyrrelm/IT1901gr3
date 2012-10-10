package client;

import helpclasses.CommEnum;
import helpclasses.CommMessage;
import helpclasses.Owner;

import java.util.ArrayList;

public class DbDownload {
	 public static void loadFarms(){
	    	ArrayList<Owner> metadata = new ArrayList<Owner>();
	    	metadata.add(ServerData.owner); 
	    	Client.sockCli.sendMessage(new CommMessage<Owner>(CommEnum.GETFARMS, metadata));
	    }
}
