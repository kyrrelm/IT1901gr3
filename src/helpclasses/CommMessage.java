package helpclasses;

import java.io.Serializable;
import java.util.ArrayList;

public class CommMessage<T> implements Serializable
{

	String messageName;
	ArrayList<T> paramList;
	
	public CommMessage(String messageName, ArrayList<T> paramList)
	{
		this.messageName = messageName;
		this.paramList =  paramList;
	}

	public String getMessageName() {
		return messageName;
	}

	public ArrayList<T> getParamList() {
		return paramList;
	}

}
