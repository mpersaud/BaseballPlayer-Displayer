import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class DisplayMenuHandler implements ActionListener {
	JFrame jframe;
	static PlayerList list = new PlayerList();
	static JTextArea text= new JTextArea();
	/**
	 * constructor for displaymenu
	 * @param jf jFrame
	 * @param l list that is passed in
	 * @param left textarea 
	 */
	public DisplayMenuHandler(JFrame jf,PlayerList l, JTextArea left) {
		jframe = jf;
		list = l;
		text=left;

	}
/**
 * handle actions when each is picked on
 */
	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("All")){
			
			text.setText(list.toString());
			text.setBackground(Color.cyan );
		}
		else if (menuName.equals("Fielder")){
			
			
			text.setText(list.printFielder());
			text.setBackground(Color.orange );
		}
		else if (menuName.equals("Pitcher")){
			
			text.setText(list.printPitcher());
			text.setBackground(Color.green );
		}
		
	} // actionPerformed
}