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
	
	public static ArrayList<Message> filterMessages(boolean onlyAlarm,
			String farmName, int sheepId, boolean allFarms, boolean allSheeps){
		ArrayList<Message> tmp = (ArrayList<Message>) messages.clone();
		int size = tmp.size();
		for (int i = 0; i < size; i++) {
			if (onlyAlarm != tmp.get(i).isAlarm()){
				tmp.remove(i);
				size--;
			}
			else if(!allFarms){
				if (getFarmByName(farmName).getFarmId() != tmp.get(i).getSheep().getFarmId()){
					tmp.remove(i);
					size--;
				}
			}
			else if(!allSheeps){
				if (sheepId != tmp.get(i).getSheepId()){
					tmp.remove(i);
					size--;
				}
			}
		}
		return tmp;
	}
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
	public static String[] getFarmNames(){
	    if(ServerData.farms.isEmpty())
	    	return new String[] {"You have no farm's"};
	    String[] tmp = new String[ServerData.farms.size()];
	    for (int i = 0; i < tmp.length; i++) {
		tmp[i] = ServerData.farms.get(i).getName();
		}
	    return tmp;
	}
	public static String[] getFarmNamesPlusAllFarms(){
	    if(ServerData.farms.isEmpty())
	    	return new String[] {"You have no farm's"};
	    String[] tmp = new String[ServerData.farms.size()+1];
	    tmp[0] = "All farms";
	    for (int i = 1; i < tmp.length; i++) {
		tmp[i] = ServerData.farms.get(i-1).getName();
		}
	    return tmp;
	}
}
