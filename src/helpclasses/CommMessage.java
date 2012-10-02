package helpclasses;

import java.io.Serializable;
import java.util.ArrayList;

public class CommMessage<T> implements Serializable
{

	CommEnum messageName;
	ArrayList<T> paramList;
	
	public CommMessage(CommEnum c, ArrayList<T> paramList)
	{
		this.messageName = c;
		this.paramList =  paramList;
	}

	public CommEnum getMessageName() {
		return messageName;
	}

	public ArrayList<T> getParamList() {
		return paramList;
	}

}
