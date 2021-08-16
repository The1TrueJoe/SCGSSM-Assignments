import java.util.ArrayList;
import java.util.ArrayList;

/**
 * Q10: I have neither given or received unauthorized help on this assignment.
 * 
 * This is the class for a min heap
 * 
 * Q1: Written in Java
 * Q8: Written in Java
 * 
 * @author JosephTelaak
 */

public class MinHeap {
	
	// Heap
	private ArrayList<Integer> heap;
	
	/* Constructor
	 * 
	 * Q2: Starting from 0
	 */
	public MinHeap(ArrayList<Integer> items) {

        this.heap = items;
        buildHeap();
        
    }

	/**
	 * Intialize heap
	 * 
	 * Q3: 
	 */
	private void buildHeap() {
		
		for (int i = heap.size() / 2; i >= 0; i--) {
            heapify(i);
            
        }
	        
	} 
	
	/**
	 * Heapify
	 * 
	 * Q3: Floyd’s
	 * 
	 * @param index
	 */
	
	
    public  void heapify(int index) { 
    	int smallest = -1;
        
    	int left = getLeftChildIndex(index); 
        int right = getRightChildIndex(index); 
        
        if (left <= heap.size() - 1 && heap.get(left) < heap.get(index)) {
            smallest = left;
            
        } else {
            smallest = index;
            
        }

        if (right <= heap.size() - 1 && heap.get(right) < heap.get(smallest)) {
            smallest = right;
            
        }

       
        if (smallest != index) {

        	int temp = heap.get(smallest);
            heap.set(smallest, heap.get(index));
            heap.set(index, temp);
            
            heapify(smallest);
            
        }
    }
    
    /**
     * Adds an item to the end of a heap and will re-heapify
     * 
     * Q4
     * Q7
     * 
     * @param item
     */
    
    public void add(int item) {

        heap.add(item);
        
        buildHeap();
    }
    
    public void remove(int item) {
    	heap.remove(heap.indexOf(item));
    	
    	buildHeap();
    }
    
    /**
     * Get parent index from a given index
     * 
     * Q5
     * 
     * @param index
     * @return parent index
     */
    
    public int getParentIndex(int index) {
    	if (index % 2 == 1) {
            return index / 2;
            
        } else {
        	return (index - 1) / 2;
        	
        }
    }
    
    /**
     * Get right child index from a given index
     * 
     * Q5
     * 
     * @param index
     * @return left child index
     */
    
    public int getLeftChildIndex(int index) {
    	return (2 * index) + 1; 
    	
    }
    
    /**
     * Get right child index from a given index
     * 
     * Q5
     * 
     * @param index
     * @return right child index
     */
    
    public int getRightChildIndex(int index) {
    	return (2 * index) + 2;
    	
    }
    
    /**
     * ToString
     * 
     * @return heap as a String
     */
     
    public String toString() {
    	String output = "Heap: ";
    	
    	for (int i = 0; i < heap.size(); i++) {
    		output += heap.get(i) + ", ";
    		
    	}
    	
    	return output;
    	
    }
	
	public static void main(String[] args) {
		 int arrC[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
		 
		 ArrayList<Integer> input = new ArrayList<Integer>();
		 
		 for (int x : arrC) {
			 input.add(x);
			 
		 }
		 
		 MinHeap heap = new MinHeap(input);
		 
		 //Q9
		 
		 System.out.println(heap);
		 
		 /*
		  * Builds
		  * Prints
		  * 
		  * Output: 3, 5, 9, 6, 8, 20, 10, 12, 18, 9
		  */
		 
		 heap.remove(3);
		 System.out.println(heap);
		 
		 /*
		  * Removes 3
		  * Prints
		  * 
		  * Output: 5, 8, 6, 9, 20, 10, 12, 18, 9
		  */
		 
		 heap.add(2);
		 System.out.println(heap);
		 
		 /*
		  * Adds 2
		  * Prints
		  * 
		  * Output: 2, 5, 6, 9, 8, 10, 12, 18, 9, 20
		  */
		 
	}

}
