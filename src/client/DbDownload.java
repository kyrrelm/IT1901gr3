package client;

import helpclasses.CommEnum;
import helpclasses.CommMessage;
import helpclasses.Owner;

import java.util.ArrayList;

public class DbDownload {
	 public static void loadFarms(){

	    	Client.sockCli.sendMessage(new CommMessage<String>(CommEnum.GETFARMS, null));
	    }
}
