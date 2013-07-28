package gui;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static MainFrame instance = new MainFrame();

	private JTextField textField;	
	
	JTextArea textArea;
	
	public MainFrame(){
		
		super ("RSS Reader");
		//set layout manager
        this.setLayout(new BorderLayout());
        //set close action
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add a menu bar with a file menu and open menu item
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        //set as stand menu bar of main frame
        this.setJMenuBar(menuBar);
        //create a text area in center
        textArea = new JTextArea();
        textArea.setText("");
        //add to jframe component and set to the center
        this.add(textArea, BorderLayout.CENTER);
	}
	
	public void setText(String text){
		textArea.setText(text);
	}
	
	public void appText(String text){
		textArea.append(text);
	}
		
}
