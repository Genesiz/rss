package rssRead;

import java.net.URL;

public class RssElement {
	
	String title, desc, date;
	URL link;
	
	public RssElement(String title, URL link, String desc, String date){
		this.title = title;
		this.desc = desc;
		this.date = date;
		this.link = link;
	}
	
	public String getTitle(){
		return title;
	}
	
	public URL getLink(){
		return link;
	}
	
	public String getDesc(){
		return desc;
	}
	public String getDate(){
		return date;
	}
}
