/**
   *  Pitcher class which is extended from baseballPlayer
   *
   */
public class Pitcher extends BaseballPlayer{
	private float era;
	/**
	   *  constructor for Pitcher class
	   *  @param e is the era for the Pitcher
	   *
	   */
	public Pitcher (int num, String l, String f, float r,float e){
		
		super(num,l,f,r);
		if(e<0 ) throw new IllegalPlayerException("Invalid era  "+ e);
		era = e;
		
	}
	/**
	   *  setter function for ERA
	   *
	   */
	public void setPlayerEra(float e){
		if(e<0 ) throw new IllegalArgumentException("Invalid ERA" + e);
		era =e;
	}
	
	@Override
	public String toString(){
		/**
		 * @return returns a string with names of the elements in particular order
		 */
		return getPlayerNumber() +" " + getPlayerlastname() + " , " + getPlayerfirstname() +"  " + "Avg:  ("+ getPlayerRbi() +")  " + "ERA: ("+ era +")  " +"\n";
	}
}
