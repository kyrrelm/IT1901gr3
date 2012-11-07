package map;

import helpclasses.Message;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class GenerateMap {
	
	final static String prefixPath = "map/prefix.txt";
	final static String suffixPath = "map/suffix.txt";
	
	
	
	
	
	static String prefix = "";
	static String suffix = "";
	
//	public static void main(String[] args)
//	{
//		initGenerator();
//		ArrayList<Message> test = new ArrayList<Message>();
//		test.add(new Message(12, new Date(0), 1, 1, 1, 9.0, 62.5, 1, null));
//		test.add(new Message(13, new Date(0), 1, 1, 1, 8.0, 61.5, 1, null));
//		test.add(new Message(14, new Date(0), 1, 1, 1, 7.0, 63.5, 2, null));
//		test.add(new Message(15, new Date(0), 1, 1, 1, 5.0, 62.5, 2, null));
//		test.add(new Message(16, new Date(0), 1, 1, 1, 5.0, 62, 3, null));
//		test.add(new Message(17, new Date(0), 1, 1, 1, 8.0, 62, 1, null));
//		UpdateMap(test);
//	}
	
	
	public static void initGenerator()
	{
		prefix = loadFile(prefixPath);
		suffix = loadFile(suffixPath);
	}
	
	public static  String loadFile(String fileName)
	{	
		
		String path = GenerateMap.class.getClassLoader().getResource(fileName).getPath().replaceAll("%20",  " ");
		
		try {
			StringBuffer fileData = new StringBuffer(2000);
			BufferedReader reader = new BufferedReader(
					new FileReader(path));
			
			char[] buf = new char[1024];
			
			int numRead = 0;
			while((numRead = reader.read(buf)) != -1)
			{
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
			
			reader.close();
			
			return fileData.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("ERROR");
		}
		
		return "";
	}
	
	
	public static void UpdateMap(ArrayList<ArrayList<Message>> sortedmsg)
	{
		String path =  GenerateMap.class.getClassLoader().getResource(gui.MapPanel.localURL).getPath().replaceAll("%20",  " ");
		
		
		ArrayList<Integer> sheepIDs  = new ArrayList<Integer>();
		//sorter arraylist message inn i arraylist<Arraylist<msg>!
		
		try {
			File file = new File(path);
			
			if (!file.exists())
				file.createNewFile();
			
			
			BufferedWriter fw = new BufferedWriter(new FileWriter(file));
			
			fw.write(prefix);
			int sheepCount = 0;
			for (ArrayList<Message> l: sortedmsg)
			{
				String pointString = "\n\t\tmainArray[" + sheepCount + "] = [";
				String lineString = "\n\t\tlineArray[" + sheepCount + "] = [";
				for (int i = 0; i < l.size(); i++)
				{
					// pointString:
					Message m = l.get(i);
					pointString += "createMarker(new GLatLng(" + m.getPositionX() + ", " + m.getPositionY() + "),\"" + m.toStringMap() + "\", " + m.isAlarm() + ")";
					// hvis det ikke er det siste elementet: legg til et komma
					if ((i + 1) < l.size())
					{
						pointString += ",";
					}
					
					//lineString:
					// kun legg til points hvis i er odd.
					if (i % 2 == 1) // odd
					{
						boolean lower = (i - 1) >= 0;
						boolean upper = (i + 1) < l.size();
						
						if (lower)
						{
							Message prev = l.get(i-1);
							lineString += "new GPolyline([new GLatLng(" + prev.getPositionX() + ", " + prev.getPositionY() + "), new GLatLng(" + m.getPositionX() + ", " + m.getPositionY() + ")], \"ff0000\", 5)";
							
							// if there are more lines to be added, add a comma
							if (upper)
								lineString += ",";
						}
						
						if (upper)
						{
							Message next = l.get(i+1);
							lineString += "new GPolyline([new GLatLng(" + m.getPositionX() + ", " + m.getPositionY() + "), new GLatLng(" + next.getPositionX() + ", " + next.getPositionY() + ")], \"ff0000\", 5)";
							
							// if there are more lines to be added, add a comma
							if ((i + 1 + 1) < l.size())
								lineString += ",";
						}
						
					}
						
					
				}
				// end the strings
				pointString += "];";
				lineString += "];";
				
				// write the strings
				fw.write(pointString);
				fw.write(lineString);				
				sheepCount++;
			}
			
			String test = "createMarker(new GLatLng( Y , X ),\" desc \")";
			/*
			for (Message m : msg) {
				fw.write("map.addOverlay(createMarker(new GLatLng("+m.getPositionY()+","+ m.getPositionX()+"),\""+ m.toStringMap()+"\"));\n");
				
				
			}*/
			fw.write(suffix);
			
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// lag en fil kalt map.html
		// legg til prefix
		
		// TODO: Legg til alle points!
		
		// legg til suffix
		
	}
}
