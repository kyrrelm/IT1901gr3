package helpclasses;

import java.io.Serializable;
import java.util.List;

public class CommMessage<T> implements Serializable
{

	String messageName;
	List<T> paramList;
	
	public CommMessage(String messageName, List<T> paramList)
	{
		this.messageName = messageName;
		this.paramList =  paramList;
	}

	public String getMessageName() {
		return messageName;
	}

	public List<T> getParamList() {
		return paramList;
	}

}
