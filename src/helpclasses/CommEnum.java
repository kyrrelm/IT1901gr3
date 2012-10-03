package helpclasses;

public enum CommEnum {
	
	//LOGIN REQUEST CLIENT->SERVER
	LOGIN,
	
	//LOGIN REPLY SERVER->CLIENT
	// -- OK
	LOGINSUCCESSFUL,
	
	// -- WRONG INFO
	LOGINFAILED,
	
	//SERVER->CLIENT ERROR MESSAGE: NOT LOGGED IN
	NOTLOGGEDIN,
	
	//SERVER->CLIENT GENERAL SUCCESS MESSAGE
	SUCCESS,
	
	
	
	
	
	//CLIENT->SERVER ADD SHEEP
	ADDSHEEP,
	
	//SERVER->CLIENT SHEEP REPLY
	SHEEPREPLY,
	
	
	
	//CLIENT->SERVER ADD MULTIPLE SHEEP
	ADDFLOCK,
	
	//SERVER->CLIENT MULTIPLE SHEEP REPLY
	FLOCKREPLY,
	
	
	
	//CLIENT->SERVER RETRIEVE ALL MESSAGES
	GETMESSAGES,
	
	//SERVER->CLIENT ALL MESSAGE REPLY
	MESSAGESREPLY,
	
}
