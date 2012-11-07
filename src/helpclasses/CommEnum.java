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
	
	//CLIENT->SERVER GET FARMS
	GETFARMS,
	//SERVER->CLIENT RETURN ALL FARMS
	FARMSREPLY,
	
	//CLIENT->SERVER ADD FARM
	ADDFARM,
	//CLIENT->SERVER REMOVE FARM
	REMOVEFARM,
	
	
	
	
	
	//CLIENT->SERVER ADD SHEEP
	ADDSHEEP,
	//CLIENT->SERVER REMOVE SHEEP
	REMOVESHEEP,
	
	

	//CLIENT->SERVER GET FARMS
	GETSHEEP,
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
	
	//CLIENT->SERVER UPDATE CONTACT INFORMATION
	UPDATECONTACTINFORMATION,
        
    //CLIENT->SERVER REGISTER NEW USER
    REGISTERNEWUSER,
	
	// SERVER -> CLIENT UPDATED MESSAGES
	NEWMESSAGES,
	
	// SERVER-> CLIENT ALARM notification
	NEWALARM
	
	
}
