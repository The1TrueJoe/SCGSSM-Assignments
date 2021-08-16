import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class AlgoTest {

	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<Integer>();
		
		ArrayList<Integer> selection;
		ArrayList<Integer> merge;

		long time;

		Random rand = new Random();
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter Starting Size: ");
		int initialSize = keyboard.nextInt();
		
		System.out.println("Enter Number of Iterations: ");
		int iterations = keyboard.nextInt();

		System.out.println("Enter Increment: ");
		int increment = keyboard.nextInt();

		keyboard.close();
		System.out.println("\n");

		time = System.currentTimeMillis();
		System.out.println("(Array Generation) Creating initial array of " + initialSize + " values");

		for (int y = 0; y < initialSize; y++)
			array.add(rand.nextInt());

		System.out.println("(Array Generation) Took " + (System.currentTimeMillis() - time) + " ms\n");

		for (int x = 0; x < iterations; x++) {

			System.out.println("Run " + (x + 1));

			time = System.currentTimeMillis();	
			System.out.println("(Array Generation) Loading " + initialSize + " values");
	
			if (x > 0) {
				for (int i = 0; i < increment; i++)
					array.add(rand.nextInt());
			}

			System.out.println("(Array Generation) Took " + (System.currentTimeMillis() - time) + " ms");
			System.out.println("(Array Generation) Size: " + array.size() + "\n");

			selection = new ArrayList<Integer>();
			merge = new ArrayList<Integer>();

			for (int i : array) {
				selection.add(i);
				merge.add(i);
			};

			System.out.println("(Selection Sort) Beginning....");
			time = System.currentTimeMillis();
			selectionSort(selection);
			System.out.println("(Selection Sort) Took " + (System.currentTimeMillis() - time) + " ms\n");

			System.out.println("(Merge Sort) Beginning....");
			time = System.currentTimeMillis();
			mergeSort(merge, 0, array.size() - 1);
			System.out.println("(Merge Sort) Took " + (System.currentTimeMillis() - time) + " ms\n");

			initialSize += increment;

		}
	}

	public static void selectionSort(ArrayList<Integer> array) {
    		for (int i = 0; i < array.size(); i++) {
        
			int min = array.get(i);
        		int minId = i;
        
			for (int j = i + 1; j < array.size(); j++) {
            			if (array.get(j) < min) {
                			min = array.get(j);
                			minId = j;
            			}
        		}

        		int temp = array.get(i);
        
			array.set(i, min);
        		array.set(minId, temp);
    		}
	}



	public static void mergeSort(ArrayList<Integer> array, int beg, int end) {
		if (end <= beg) return;
		
		int mid = (beg+end)/2;
		
		mergeSort(array, beg, mid);
		mergeSort(array, mid+1, end);
		merge(array, beg, mid, end);
	}


	public static void merge(ArrayList<Integer> array, int beg, int mid, int end)  {  
  
		int l = mid - beg + 1;  
		int r = end - mid;  
  
		int LeftArray[] = new int[l];  
		int RightArray[] = new int[r];  
  
		for (int i = 0; i < l; i++)  
			LeftArray[i] = array.get(beg + i);  
  	
		for (int j=0; j<r; ++j)  
			RightArray[j] = array.get(mid + 1 + j);  
  
  
		int i = 0, j = 0;  
		int k = beg;  

		while (i < l && j < r)  {  
			if (LeftArray[i] <= RightArray[j])  {  
				array.set(k, LeftArray[i]);  
				i++;  

			}  else  {  
				array.set(k, RightArray[j]);  
				j++;  

			}  

		k++;  

		}  

		while (i < l)  {  
			array.set(k, LeftArray[i]);  
			i++;  
			k++;  
		}  
  

		while (j < r)  {  
			array.set(k, RightArray[j]);  
			j++;  
		k++;  

		}  	
	}  
}
