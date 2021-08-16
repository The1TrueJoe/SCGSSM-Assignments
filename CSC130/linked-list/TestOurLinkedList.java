public class TestOurLinkedList {

	public static void main(String[] args)
    {
		 System.out.println("Test the our linked list");
        
		 OurLinkedList hg = new OurLinkedList();
         
		 hg.addFirst("One");
         System.out.println("Get First " + hg.getFirst());
         hg.addFirst("Two");
         System.out.println("Get First " + hg.getFirst());
         Object rm =  hg.removeFirst(); 
         String rmString = (String)rm;
         System.out.println("Removed "+ rmString );
       
         //now test the list iterator 
         ListIterator ours = hg.listIterator();
         System.out.println("Get Next " + ours.next());
         String item = "AnotherOne";
         System.out.println("Added " + "AnotherOne");
         ours.add(item);
         
         if ( ours.hasNext() ) {
        	 ours.set(item);
         }
         
         System.out.println("Size " + hg.size());
         
         System.out.println("Removed " + hg.removeFirst());
         System.out.println("Removed " + hg.removeFirst());
         
         hg.addFirst("AnotherOne");
         hg.addFirst("One");
         
         System.out.println("Added " + "AnotherOne");
         System.out.println("Added " + "One");
         
         System.out.println("Reversing");
         
         hg.reverse();
         
         System.out.println("Removed " + hg.removeFirst());
         System.out.println("Removed " + hg.removeFirst());
      
	}

}
