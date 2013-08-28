package rssRead;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Reader {
	
	public static ArrayList<RssElement> rssFeed = new ArrayList<RssElement>();
	
	
	public static String readRss (String urlAdress){
		try{
		URL rssURL = new URL(urlAdress);
		BufferedReader input = new BufferedReader(new InputStreamReader(rssURL.openStream()));
		String line, title = null, desc = null;
		URL  link = null;
		
		while ((line = input.readLine()) != null){
			
			if (line.contains("<item>")){
		
		while ((line = input.readLine()) != null){
			if (line.contains("<title>")){
				int start = line.indexOf("<title>");
				String titletemp = line.substring(start);
				titletemp = titletemp.replace("<title>", "");
				int stop = titletemp.indexOf("</title>");
				titletemp = titletemp.substring(0, stop);
				title = titletemp;
				System.out.println(titletemp);
			} 
			if (line.contains("<link>")){
				int start = line.indexOf("<link>");
				String linktemp = line.substring(start);
				linktemp = linktemp.replace("<link>", "");
				int stop = linktemp.indexOf("</link>");
				linktemp = linktemp.substring(0, stop);
				link = new URL(linktemp);
				System.out.println(linktemp);
			} 
			if (line.contains("<description>")){
				int start = line.indexOf("<description>");
				String desctemp = line.substring(start);
				desctemp = desctemp.replace("<description><![CDATA[", "");
				int stop = desctemp.indexOf("]]></description>");
				desctemp = desctemp.substring(0, stop);
				desc = desctemp;
				System.out.println(desctemp);
				
			}
			if (line.contains("</item>"))
				rssFeed.add(new RssElement(title, link, desc, null));
			
				}
		
			}
		}
		input.close();
		String size = Integer.toString(rssFeed.size());
		System.out.println(size);
		
	}	catch (MalformedURLException ue){
		System.out.println("Malformed URL");
	}	catch (IOException ioe){
		System.out.println("something went wrong reading RSS");
	}
		return null;
	}

}