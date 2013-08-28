import rssRead.*;
import gui.*;


public class Main {

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
        frame.setSize(800, 600);
        frame.setVisible(true);
        Reader.readRss(" http://beep.tv2.dk/rss.xml.php/index.xml");

        
 int i = 1;
        
        while (!Reader.rssFeed.isEmpty() && Reader.rssFeed.size() > i){
        	frame.appText(Reader.rssFeed.get(i).getTitle());
        	frame.appText("\n" + Reader.rssFeed.get(i).getLink() + "\n \n");
        	i++;
        	
        }
	}

}
