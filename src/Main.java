import rssRead.*;
import gui.*;


public class Main {

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
        frame.setSize(800, 600);
        frame.setVisible(true);
        Reader.readRss(" http://beep.tv2.dk/rss.xml.php/index.xml");
        
        int i = 1;
        
        while (!Reader.titles.isEmpty() && Reader.titles.size() > i){
        	frame.appText(Reader.titles.get(i));
        	frame.appText("\n \n");
        	i++;
        	
        }
	}

}
