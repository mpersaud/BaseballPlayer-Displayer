// LinkedList.java
// 
// This version uses three instance variables,
// a pointer to the first node, a pointer to
// the last node, and length, to make our
// append and getLength methods more efficient
// than the would be if our only instance
// variable were a pointer to the first node.
//
// This version uses a dummy first node.  Hence
// it needs less decision-making than it would
// need if a dummy first node were not used.
//

/**
 * Encapsulates a linked list of <code>String</code>.
 */
public  class PlayerList {

/**  First node in linked list - dummy node  */
   private PlayerNode first = new PlayerNode(null);

/**  Last node in linked list  */
   private PlayerNode last = first;

/**  Number of data items in the list.  */
   private int length = 0;

  /**
    * Gets the number of data values currently
    * stored in this LinkedList.
    *
    * @return the number of elements in the list.
    */

   public int getLength()  { 
      return length; 
   }
   public PlayerNode getFirst()  { 
	      return first; 
	   }

   /**
    * Appends a String data element to this
    * LinkedList.
    *
    * @param data the data element to be appended.
    */
   public void append(BaseballPlayer d)
   {

     //  write the code here for append
	   PlayerNode n = new PlayerNode (d);
	   last.next = n;
	   last = n;
	   length++;
	   
   }  // method append(String)
   /**
    *  inserts baseballplayer in right position in linked list
    *
    */
   public void insertPlayer (BaseballPlayer d) {
       if (first.next == null)  
        {
            first.next = new PlayerNode(d);
            last = new PlayerNode(d);
        }
       else{
       if (d.getPlayerNumber() < first.next.getData().getPlayerNumber()){
           first.next = new PlayerNode(d,first.next); 
       } else {
           PlayerNode current = first.next;
           PlayerNode previous = first.next;
           while (current != null){
               if(current.getData().getPlayerNumber()<d.getPlayerNumber()){
                   previous = current;
                   current = current.next;
               }else {
                   previous.next= new PlayerNode(d, current); 
                   break;
               } 
           } 
           if (current == null){
               previous.next = new PlayerNode(d); 
           }
       }
     }
   }
   
   public PlayerList sortList(PlayerList l) {
	   PlayerList x = new PlayerList();
	   PlayerNode p = l.first.next;
	      while (p != null) {
	    	  
	    	x.insertPlayer(p.data);
			 p = p.next; 
	      }
	      l=x;
	      return l;
   }      
  /*
   *  Prints the contents of the Linked List
   *
   */
   public String toString() {
	      PlayerNode p = first.next;
	   
	      String returnString = "";
	     
	      while (p != null) {
	    	  if (p.data instanceof Fielder)
					 returnString += p.data+" ";
	    	  if (p.data instanceof Pitcher)
					 returnString += p.data+" ";
			 p = p.next;
	      }
	     	  
	      return returnString;
	      
	   }
   public String printFielder() {
	      PlayerNode p = first.next;
	   
	      String returnString = "";
	     
	      while (p != null) {
	    	  if (p.data instanceof Fielder)
					 returnString += p.data+" ";
	    	 
			 p = p.next;
	      }
	     	  
	      return returnString;
	      
	   }
   public String printPitcher() {
	      PlayerNode p = first.next;
	   
	      String returnString = "";
	     
	      while (p != null) {
	    	 
	    	  if (p.data instanceof Pitcher)
					 returnString += p.data+" ";
			 p = p.next;
	      }
	     	  
	      return returnString;
	      
	   }

}  // class LinkedList

