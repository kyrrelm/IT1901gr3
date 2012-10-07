package client;

import helpclasses.Farm;
import helpclasses.Message;
import helpclasses.Owner;

import java.util.ArrayList;
import java.util.Iterator;

import com.sun.org.apache.bcel.internal.generic.NEW;


public class ServerData {

	public static boolean isLoggedIn = false;
	public static Owner owner;
	public static ArrayList<Message> messages = new ArrayList<Message>();
	public static ArrayList<Farm> farms = new ArrayList<Farm>();
	
	public static Farm getFarmByNameAndRemove(String name){
		for (Farm farm : farms) {
			if(farm.getName().equals(name)){
				Farm tmp = farm;
				farms.remove(farm);
				return tmp;
			}
		}
		return null;
	}
	public static Farm getFarmByName(String name){
		for (Farm farm : farms) {
			if(farm.getName().equals(name)){
				return farm;
			}
		}
		return null;
	}
}
