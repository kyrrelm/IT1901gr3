package client;

import helpclasses.Farm;
import helpclasses.Message;
import helpclasses.Owner;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEW;


public class ServerData {

	public static boolean isLoggedIn = false;
	public static Owner owner;
	public static ArrayList<Message> messages = new ArrayList<Message>();
	public static ArrayList<Farm> farms = new ArrayList<Farm>();
}