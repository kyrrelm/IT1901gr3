package client;

import helpclasses.Farm;
import helpclasses.Message;
import helpclasses.Owner;
import helpclasses.Sheep;

import java.util.ArrayList;
import java.util.Iterator;

import com.sun.org.apache.bcel.internal.generic.NEW;


public class ServerData {

	public static boolean isLoggedIn = false;
	public static Owner owner;
	public static ArrayList<Message> messages = new ArrayList<Message>();
	public static ArrayList<Farm> farms = new ArrayList<Farm>();
	public static ArrayList<Sheep> sheep = new ArrayList<Sheep>();

	/**
	 * @author Kyrre and Jamawadi
	 * Filter messages after the given param
	 * @param onlyAlarm only shows alarm messages
	 * @param farmName Name of farm
	 * @param sheep Object of type Sheep
	 * @param allFarms Shows sheep from all farms
	 * @param allSheeps Show all sheep from the given farm
	 * @return ArrayList<Message>
	 */
	public static ArrayList<Message> filterMessages(boolean onlyAlarm,
			String farmName, String sheep, boolean allFarms, boolean allSheeps){
		ArrayList<Message> tmp = (ArrayList<Message>) messages.clone();
		for (int i = 0; i < tmp.size(); i++) {
			if (onlyAlarm != tmp.get(i).isAlarm()){
				tmp.remove(i--);
			}
			else if(!allSheeps){
				if (Integer.parseInt(sheep) != tmp.get(i).getSheepId()){
					tmp.remove(i--);
				}
			}
			else if(!allFarms){
				if (getFarmByName(farmName).getFarmId() != tmp.get(i).getSheep().getFarmId()){
					tmp.remove(i--);
				}
			}
		}
		return tmp;
	}
	/**
	 * @author Kyrre
	 * @param name Name of farm
	 * If a farm with this name exist in Arraylist Farm
	 * remove it from the list, and then return it. 
	 * @return Object of type Farm
	 */
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
	/**
	 * @author Kyrre
	 * @param name
	 * @return Object Farm with param name as it's name
	 */
	public static Farm getFarmByName(String name){
		for (Farm farm : farms) {
			if(farm.getName().equals(name)){
				return farm;
			}
		}
		return null;
	}
	/**
	 * @author Kyrre
	 * @return String[] of farm names from List farm
	 */
	public static String[] getFarmNames(){
		if(farms.isEmpty())
			return new String[] {"You have no farms"};
		String[] tmp = new String[farms.size()];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = farms.get(i).getName();
		}
		return tmp;
	}
	/**
	 * @author Kyrre
	 * returns String[] Name of all farms,
	 * pluss the String "All farms" at index 0
	 * If farms is empty index 0 will contain "You have no farms"
	 * @return String[]
	 */
	public static String[] getFarmNamesPlusAllFarms(){
		if(farms.isEmpty())
			return new String[] {"You have no farms"};
		String[] tmp = new String[farms.size()+1];
		tmp[0] = "All farms";
		for (int i = 1; i < tmp.length; i++) {
			tmp[i] = farms.get(i-1).getName();
		}
		return tmp;
	}
	/**
	 * @author Kyrre
	 * returns String[] Name of all sheep at the given farm,
	 * pluss the String "All sheep" at index 0.
	 * If sheep is empty index 0 will contain "You have no sheep"
	 * @return String[]
	 */
	public static String[] getSheepNamesByFarmName(String farm) {
		if(sheep.isEmpty())
			return new String[] {"You have no sheep"};
		ArrayList<String> tmp = new ArrayList<String>();
		tmp.add("All sheep");
		if (farm.equals("All farms")){
			for (Sheep s : sheep) {
				tmp.add(""+s.getSheepId());
			}
			return tmp.toArray(new String[tmp.size()]);
		}	
		for (Farm f : farms) {
			if(f.getName().equals(farm)){
				for (Sheep s : sheep) {
					if (s.getFarmId() == f.getFarmId()) {
						tmp.add(""+s.getSheepId());
					}
				}
				return tmp.toArray(new String[tmp.size()]);
			}	
		}
		return new String[] {"Error: Something went wrong"};
	}
}
