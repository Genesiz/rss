package rssRead;

import java.net.*;
import java.io.*;

public class Reader {
	
	public static String readRss (String urlAdress){
		try{
		URL rssURL = new URL(urlAdress);
		BufferedReader input = new BufferedReader(new InputStreamReader(rssURL.openStream()));
		String sourceCode = "";
		String line;
		while ((line = input.readLine()) != null){
			if (line.contains("<title>")){
				int start = line.indexOf("<title>");
				String temp = line.substring(start);
				temp = temp.replace("<title>", "");
				int stop = temp.indexOf("</title>");
				temp = temp.substring(0, stop);
				sourceCode += temp+"\n";
			}
		}
		input.close();
		return sourceCode;
	}	catch (MalformedURLException ue){
		System.out.println("Malformed URL");
	}	catch (IOException ioe){
		System.out.println("something went wrong reading RSS");
	}
		return null;
	}

}