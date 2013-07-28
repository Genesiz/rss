package rssRead;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Reader {
	
	public static ArrayList<String> titles = new ArrayList<String>();
	
	
	public static String readRss (String urlAdress){
		try{
		URL rssURL = new URL(urlAdress);
		BufferedReader input = new BufferedReader(new InputStreamReader(rssURL.openStream()));
		String line, title = null, link = null, desc = null;
		
		
		while ((line = input.readLine()) != null){
			if (line.contains("<title>")){
				int start = line.indexOf("<title>");
				String temp = line.substring(start);
				temp = temp.replace("<title>", "");
				int stop = temp.indexOf("</title>");
				temp = temp.substring(0, stop);
				titles.add(temp);
				System.out.println(temp);
			} 
		}
		input.close();
		
	}	catch (MalformedURLException ue){
		System.out.println("Malformed URL");
	}	catch (IOException ioe){
		System.out.println("something went wrong reading RSS");
	}
		return null;
	}

}