import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener {
	static PlayerList list = new PlayerList();
	static TextFileInput myFile; 
	
	JFrame jframe;
	
	public FileMenuHandler(JFrame jf) {
		jframe = jf;
	}
	
	public PlayerList getList(){
		return list;
	}
/**
 * handles what to do if open or quit is clicked
 */
	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Open")){
			openFile();
			
		}
		else if (menuName.equals("Quit"))
			System.exit(0);
	} // actionPerformed

	private void openFile() {
			list.getFirst().next = null;
		   JFileChooser chooser = new JFileChooser( );
		   chooser.showOpenDialog(null);
		   File f= chooser.getSelectedFile();
		   readData(f);
		   
	}//openFile
/**
 * reads in file and throw exceptions if not in correct format
 * @param file
 */
	public static void readData(File file){
		  
	      myFile = new TextFileInput(file.getAbsolutePath());//open file
		  String line;
		  line = myFile.readLine(); 
		  while (line != null ) { //while we did not reach the end of the file
			  try{
				
			    StringTokenizer tokens=new StringTokenizer(line, " ,");
			    
			    while(tokens.hasMoreTokens()){ 
			      	
			    	char c = tokens.nextToken().charAt(0);
			    	if(c!='P' && c!='F')throw new IllegalPlayerException("Unrecongized Type ('"+c+"') in line: "+line);
			    	int count = tokens.countTokens();
			    	if((tokens.countTokens()<4)||(tokens.countTokens()>5)) throw new IllegalPlayerException("invalid number of tokens ("+count+") for type '"+c+"' in line " + line);
			    	int num= Integer.parseInt(tokens.nextToken());	
			    	if(num<0 || num >100) throw new IllegalPlayerException("invalid number"+ num);
			    	String l= tokens.nextToken();
			    	String f= tokens.nextToken();
			    	
					if((l==null )|| (f==null))throw new IllegalPlayerException("invalid name"+ l+f);
			    	float r= Float.parseFloat(tokens.nextToken());	
			    	if(r<0 || r>1) throw new IllegalPlayerException("Exception occured for line: "+line+"(Illegal Batting Average : "+r+")");
			    	if(c =='P'){
			    		if (tokens.countTokens()!=1)throw new IllegalPlayerException("invalid number of tokens ("+count+") for type '"+c+"' in line " + line);
			    		float e = Float.parseFloat(tokens.nextToken());
			    		list.insertPlayer( new Pitcher(num,l,f,r,e));		
			    	}
			    	else{				
			    		if (tokens.countTokens()!=0)throw new IllegalPlayerException("invalid number of tokens ("+count+") for type '"+c+"' in line " + line);
			    		list.insertPlayer(new Fielder(num,l,f,r));//store tokens in array which is incremented by the count
			    		
			    	}			   
			    }
			  } 
			  catch(IllegalPlayerException e){
				  System.out.println(e.getMessage());
			  }
			 finally{
			  
			 line =myFile.readLine();
			  }
		   }//while							   
		   myFile.close(); //close  		  
	}//readData
}//FileMenuHandler