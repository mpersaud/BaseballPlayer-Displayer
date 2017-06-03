import javax.swing.JFrame;

import java.awt.*;

import javax.swing.*;
/**
 * This class intalizes a GUI that the words can be printed to
 * 
 *
 */
public class PlayerGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar menuBar;
	JTextArea lefttextArea = new JTextArea();
	
	
	/**
	 * Constructor with no parameters that loads the default GUI
	 */
	public PlayerGui () {
		super("PlayerGUI");
		
		setSize(350,300);
	    setLocation(150, 150);
	    setTitle("BaseballPlayers");
	    createFileMenu();
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    getContentPane();
	    lefttextArea.setEditable(false);
		lefttextArea.setText("Import a File by Selecting Open in the File Menu");
		add(lefttextArea,BorderLayout.CENTER);
		setVisible(true);
	}
	/**
	 * creates the file menu
	 */
		private void createFileMenu() {
			menuBar = new JMenuBar();
			JMenu fileMenu = new JMenu("File");
			FileMenuHandler fmh = new FileMenuHandler(this);
			JMenuItem item;

			item = new JMenuItem("Open"); // Open...
			item.addActionListener(fmh);
			
			fileMenu.add(item);

			fileMenu.addSeparator(); // add a horizontal separator line

			item = new JMenuItem("Quit"); // Quit
			item.addActionListener(fmh);
			fileMenu.add(item);

			setJMenuBar(menuBar);
			menuBar.add(fileMenu);
			createDisplayMenu(fmh.getList(),lefttextArea);
		}
		/**
		 * creates the displaymenu
		 * @param list linkedlist thats is created from file read in
		 * @param left textarea to print linkedlist to
		 */
		private void createDisplayMenu(PlayerList list, JTextArea left) {
			JMenu editMenu = new JMenu("Display");
			DisplayMenuHandler dmh = new DisplayMenuHandler(this,list,left);
			JMenuItem item;
			
			item = new JMenuItem("All");
			item.addActionListener(dmh);
			editMenu.add(item);			
			editMenu.addSeparator();
			
			item = new JMenuItem("Fielder");
			item.addActionListener(dmh);
			editMenu.add(item);
			editMenu.addSeparator();
			

			item = new JMenuItem("Pitcher");
			item.addActionListener(dmh);
			editMenu.add(item);
			

			menuBar.add(editMenu);

		} // createMenu
	   
}//PlayerGUI
