// ListNode.java
/**
   *  PlayerNode class
   *  @param data holds baseball objects data
   *  @param next is the pointer to next object in list
   *
   */
class PlayerNode
{
   BaseballPlayer data;
   PlayerNode next;
   /**
    *  Constructor that takes in one parameter
    *
    */
   PlayerNode(BaseballPlayer d)
   {
      data = d;
      next = null;
   }  // constructor
   /**
    *  sends BaseballPlayer data to where it was called
    *
    */
   public  BaseballPlayer getData(){
	   return data;
   }
   
   public PlayerNode (BaseballPlayer d, PlayerNode n){
		data = d; 
		next = n;
   }

   public PlayerNode getNext() {return next;}
   
   public void setNext(PlayerNode n) {next = n;}
	
}  // class ListNode

