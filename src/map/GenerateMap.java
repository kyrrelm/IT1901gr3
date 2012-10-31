package map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateMap {
	
	final static String prefixPath = "map/prefix.txt";
	final static String suffixPath = "map/suffix.txt";
	
	
	
	
	
	static String prefix = "";
	static String suffix = "";
	
	public static void main(String[] args)
	{
		initGenerator();
		
		UpdateMap();
	}
	
	
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
	
	
	public static void UpdateMap()
	{
		String path =  GenerateMap.class.getClassLoader().getResource(gui.MapPanel.localURL).getPath().replaceAll("%20",  " ");
		
		System.out.println(path);
		
		try {
			File file = new File(path);
			
			if (!file.exists())
				file.createNewFile();
			
			
			BufferedWriter fw = new BufferedWriter(new FileWriter(file));
			
			fw.write(prefix);
			
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
