
public  class BaseballPlayer implements Comparable<BaseballPlayer> {
	private int number;
	private String firstname;
	private String lastname;
	private float rbi;
	/**Constructor
	 * 
	 * @param num number of player
	 * @param l lastname of player
	 * @param f firstname of player
	 * @param r batting average/rbi
	 */

	public BaseballPlayer(int num, String l, String f, float r){
		if(r<0 || r>1) throw new IllegalPlayerException("Invalid rbi "+r);
		if(num<0 || num >100) throw new IllegalPlayerException("invalid number"+ num);
		if((l==null )|| (f==null))throw new IllegalPlayerException("invalid name"+ l+f);
	
		number=num;
		firstname=f;
		lastname=l;
		rbi=r;		
	}
	
	public void setPlayerlastname(String l){
		lastname=l;		
	}
	
	public void setPlayerfirstname(String f){
		firstname=f;		
	}
	public void setPlayerNumber(int num){
		if(num<0 || num >100) throw new IllegalPlayerException("invalid number");
		number=num;
	}
	public void setPlayerRbi(float r){
		if(r<0 || r>1) throw new IllegalPlayerException("Invalid rbi");
		rbi =r;
	}
	
	public String getPlayerlastname(){
		return lastname;		
	}
	
	public String getPlayerfirstname(){
		return firstname;		
	}
	public int getPlayerNumber(){
		return number;
	}
	public float getPlayerRbi(){
		return rbi;
	}
	@Override
	public int compareTo(BaseballPlayer other){
		/**
		 * @return returns an int of negative or positive value back 
		 * to where the compareTo was called
		 */
		if (number>other.getPlayerNumber()) return 1;
		else return -1;
				
	}
	@Override
	public String toString(){
		/**
		 * @return returns a string with names of the elements in particular order
		 */
		return + number +"  " + lastname + " ,  " + firstname +"  " + "AVG: ("+ rbi +")  " + "\n";
		
	}
}//baseballPlayer
