package helpclasses;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Every object sent through the TCP connection is of the class CommMessage, messageName implicitly denotes type of paramList.
 * 
 * @author halvor
 *
 * @param <T> the type of the elements in the ArrayList
 * 
 */
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
