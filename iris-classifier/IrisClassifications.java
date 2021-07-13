import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 * 
 * On my honor, I have neither given or received unauthorized aid on this assignment
 * 
 * @author Joseph
 * @author Bunn (Psuedocode for distance calculation methods)
 */

public class IrisClassifications {
	
	/**
	 * The Iris object that contains the all data for each iris as well as certain helper methods
	 * @author Joseph
	 */
	
	public class Iris {
		
		/** Array of all data points */
		private double[] data;
		
		/** Actual iris classification read from file (For training or checking if classification is correct) */
		private String class_actual;
		
		/** Determined iris classification */
		private String class_determined;
		
		public Iris(double sepal_length, double sepal_width, double petal_length, double petal_width, String class_actual) {
			data = new double[DATA_COUNT];
			
			data[SEPAL_LENGTH] = sepal_length;
			data[SEPAL_WIDTH]  = sepal_width;
			data[PETAL_LENGTH] = petal_length;
			data[PETAL_WIDTH]  = petal_width;
			
			this.class_actual = class_actual;
			class_determined = "N/A";
		}
		
		public Iris(double[] data, String class_actual) {
			this.data = new double[DATA_COUNT];
			for (int i = 0; i < this.data.length; i++) { this.data[i] = data[i]; }
			
			this.class_actual = class_actual;
			this.class_determined = "N/A";
		}
		
		public Iris(ArrayList<Double> data, String class_actual) {
			this.data = new double[DATA_COUNT];
			for (int i = 0; i < this.data.length; i++) { this.data[i] = data.get(i); }
			
			this.class_actual = class_actual;
			this.class_determined = "N/A";
		}
		
		/** 
		 * @param type Data point found using one of the public static integers from this class
		 * @return Specified data point
		 */
		public double getData(int type) { return data[type]; }
		
		/** @return Array of all data points  */
		public double[] getData() { return data; }
		
		/** Number of data points for the Iris Class */
		public static final int DATA_COUNT    = 4;
		
		public static final int SEPAL_LENGTH  = 0;
		public static final int SEPAL_WIDTH   = 1;
		public static final int PETAL_LENGTH  = 2;
		public static final int PETAL_WIDTH   = 3;
		
		/** @return Actual iris classification from file */
		public String getActualClass() { return class_actual; }
		
		/** @return Determined iris classification */
		public String getDeterminedClass() { return class_determined; }
		
		/** Reset determined iris classification */
		public void clearClass() { class_determined = "N/A"; }
		
		/** Set the determined class @param iris_class Iris class to set*/
		public void setClass(String iris_class) { class_determined = iris_class; }
		
		/** Check determined iris classification against pre-set iris classification @return True or False */
		public boolean checkClassification() { return class_actual.equalsIgnoreCase(class_determined); }
		
		/** Check specified String against determined iris classification 
		 * 	@param iris_class Either an iris class or any String 
		 *  @return True or False
		 */
		public boolean checkClassification(String iris_class) { return iris_class.equalsIgnoreCase(class_actual); }
		
		public String toString() { return "[ Actual: " + class_actual + ", Determined: " + class_determined + 
										  ", SL: " + data[SEPAL_LENGTH] + ", SW: " + data[SEPAL_WIDTH] + 
										  ", PL:" + data[PETAL_LENGTH] + ", PW: " + data[PETAL_WIDTH]; }
		
	}
	
	// ***************************************** ATTRIBUTES ***************************************
	
	private ArrayList<Iris> irises;
	private ArrayList<Iris> averages;
	
	// Distance Calculation Types
	
	public static final int EUCLIDEAN_DISTANCE = 0;
	public static final int MANHATTAN_DISTANCE = 1;
	public static final int CHEBYSHEV_DISTANCE = 2;
	
	public int irisTypeCount;
	
	// ***************************************** DATA RETURNS *************************************
	
	public ArrayList<Iris> getIrises() { return irises; }
	public ArrayList<Iris> getAverageIrises() { return averages; }
	
	// ***************************************** CONSTRUCTOR **************************************
	
	public IrisClassifications(File file, String separationChar) {
		irises = readData(file, separationChar);
		averages = getAverages();
	}
	
	public IrisClassifications(ArrayList<Iris> irises) {
		this.irises = irises;
		averages = getAverages();
	}
	
	public IrisClassifications() {
		irises = readData(pickFile(), ",");
		averages = getAverages();
		
	}
	
	// ***************************************** MAIN *********************************************
	
	public static void main(String[] args) {
		IrisClassifications irisclass = new IrisClassifications(IrisClassifications.pickFile(), ",");
		
		System.out.println("\n\nEuclidean Distance");
		irisclass.clearClassifications();
		irisclass.classify(IrisClassifications.EUCLIDEAN_DISTANCE);
		irisclass.printResults();
		
		System.out.println("\n\nChebyshev Distance");
		irisclass.clearClassifications();
		irisclass.classify(IrisClassifications.CHEBYSHEV_DISTANCE);
		irisclass.printResults();
		
		System.out.println("\n\nManhattan Distance");
		irisclass.clearClassifications();
		irisclass.classify(IrisClassifications.MANHATTAN_DISTANCE);
		irisclass.printResults();
		
		System.out.println("Class Dump: \n" + irisclass);
		
	}
	
	// ***************************************** MISC UTILITIES ***********************************
	
	public String toString() {
		
		String string = "";
		
		for (Iris i : irises) {
			string += i + " ]\n";
		}
		
		string += " Averages \n";
		
		for (Iris i : averages) {
			string += i + " ]\n";
		}
		
		return string;
	}
	
	/*
	 * Print the results of the classifications by checking if all irises were classified correctly
	 */
	
	public void printResults() {
		
		String currentClass = irises.get(0).getActualClass();
		double correct = 0;
		double total = 0;
		
		for (int i = 0; i < irises.size(); i++) {
			
			if (!irises.get(i).checkClassification(currentClass)) { 
				System.out.println("Iris: " + irises.get(i-1).getActualClass() + " Correct: " + correct + " Total: " + total + " Score: " + String.format("%,.2f", ((correct / total) * 100)));
				
				correct = 0;
				total = 0;
				currentClass = irises.get(i).getActualClass(); 
			} 
			
			if (irises.get(i).checkClassification()) { 
				correct++; 
				total++;
			} else {
				total++;
			}
			
			
			
		}
		
		System.out.println("Iris: " + irises.get(irises.size()-1).getActualClass() + " Correct: " + correct + " Total: " + total + " Score: " + String.format("%,.2f", ((correct / total) * 100)));
	}
	
	/** Clear all determined classifications */
	
	public void clearClassifications() {
		for (Iris iris : irises) {
			iris.clearClass();
		}
	}
	
	/** Set all determined classifications to the iris's actual class*/
	
	public void setCorrectClassifications() {
		for (Iris iris : irises) {
			iris.setClass(iris.getActualClass());
		}
	}
	
	/** Set every other iris's determined class to the iris's actual class */
	
	public void setHalfCorrectClassifications() {
		for (int i  = 0; i < irises.size(); i++) {
			if (i % 2 != 0) {
				irises.get(i).setClass(irises.get(i).getActualClass());
			} else {
				irises.get(i).setClass("Other");
			}
		}
	}
	
	// ***************************************** FILE UTILITIES ***********************************
	
	/** User a JFileChooser to pick a file */
	
	public static File pickFile() {
		
		JFileChooser chooser = new  JFileChooser();   
	
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
			return chooser.getSelectedFile(); 
			
		} else { 
			return null;
			
		}
	}
	
	/**
	 * Reads the data from the file in the format ("sepal_length","sepal_width","petal_length","petal_width","class")
	 * @param file The file to be read (Either specified or found using {@link #pickFile()}
	 * @param separationChar The character(s) used to separate the data points
	 * @return An ArrayList of all irises
	 */
	
	public ArrayList<Iris> readData(File file, String separationChar) {
		
		try {
			
			System.out.println("Importing File Data");
			
			ArrayList<Iris> irisData = new ArrayList<Iris>();
			BufferedReader infile = new BufferedReader(new FileReader(file));
			
			String line = infile.readLine(); // First line is a throwaway
			
			int count = 0;
			
			while (line != null) { // Check for next line
				line = infile.readLine(); System.out.println("Reading Line: {" + line + "}"); // (Debug) Display the line being read
				if (line == null) { break; }
				
				ArrayList<Double> data = new ArrayList<Double>(); // Temp arraylist containing all read data points
				int startIndex = 0;
				int stopIndex = 0;
				String section;
				
				while (line.contains(separationChar) && startIndex != line.length()) {
					stopIndex = line.indexOf(separationChar);  // Change stopping index to the separation character
					section = line.substring(startIndex, stopIndex); // Pull section to read
					
					if (!section.isEmpty()) { data.add(Double.parseDouble(section)); } else { System.out.println("Line is empty"); }
					
					line = line.substring(stopIndex+1);
				}
				
				count++;
				irisData.add(new Iris(data, line.substring(startIndex)));
				
			}
			
			// Count amount of irises and number of classes
			
			String currentClass = "";
			irisTypeCount = 0;
			for (Iris iris : irisData) {
				if (!iris.checkClassification(currentClass)) { currentClass = iris.getActualClass(); irisTypeCount++; }
			}
			
			System.out.println("Data Import Finished " + count + " Irises. Unique: " + irisTypeCount);
			return irisData;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	/** Prints file line by line @param file File to be read */
	
	public void printFile(File file) {
		try {
		
			BufferedReader infile = new BufferedReader(new FileReader(file)); 
        
			String ourlines ="";
			String data = infile.readLine();

			if(data == null) {
				infile.close();
        	
			} else {
				data = infile.readLine();
        	
				while(data != null) {
					ourlines += "\n" + data;
					data = infile.readLine();
             
				}
        	
				infile.close();
				System.out.println(ourlines);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	// ***************************************** CALCULATIONS *************************************
	
	/*
	 * Calculates the average iris of each class (Assumes data has already been normalized)
	 */
	
	public ArrayList<Iris> getAverages() {
		
		ArrayList<Iris> averageIris = new ArrayList<Iris>();
		String currentClass = irises.get(0).getActualClass();
		double[] data = new double[Iris.DATA_COUNT];
		double count = 0;
		
		for (int i = 0; i < irises.size(); i++) {
			if (!irises.get(i).checkClassification(currentClass) || i == irises.size()-1) {
				for (int x = 0; x < data.length; x++) { data[x] = data[x] / count; }
			
				averageIris.add(new Iris(data, irises.get(i-1).getActualClass()));
				currentClass = irises.get(i).getActualClass();
				data = new double[Iris.DATA_COUNT];
				count = 0;
				
			} else {
				for (int x = 0; x < data.length; x++) { data[x] += irises.get(i).getData(x); }
				
				count++;
			}
		}
		
		return averageIris;
		
	}
	
	/**
	 * Attempt to classify the iri
	 * @param method Method of distance calculation (Ex. {@link #EUCLIDEAN_DISTANCE})
	 * @return Classification (Automatically sets the iris's determined class to its result)
	 */

	public String classify(int method) {
		clearClassifications();
		String classification = "NotFound";
		double prevtmp = 100, tmp;
		
		for (Iris iris : irises) { // Run through all irises
			
			System.out.println("Current Iris: " + iris);
			
			for (Iris avg : averages) { // Runs through each average iris
	
				tmp = getDistance(method, iris, avg); System.out.println("Distance from " + avg.getActualClass() + ": " + tmp); // Calculate distance
				
				if (prevtmp > tmp) { classification = avg.getActualClass(); } // Set classification to the iris with the lowest distance
				
				prevtmp = tmp;
			}
			
			System.out.println("Iris Determined as " + classification);
			iris.setClass(classification);
		}
		
		return classification;
	}
	
	/**
	 * Get the distance between two irises
	 * @param method Method of distance calculation to use (Use {@link #MANHATTAN_DISTANCE}, {@link #CHEBYSHEV_DISTANCE}, or {@link #EUCLIDEAN_DISTANCE})
	 * @param iris1 Iris 1
	 * @param iris2 Iris 2 (Ex. average iris)
	 * @return Distance
	 */
	
	public double getDistance(int method, Iris iris1, Iris iris2) {
		try {
			switch (method) {
			
				case EUCLIDEAN_DISTANCE:
					return euclideanDistance(iris1.getData(), iris2.getData());
			
				case MANHATTAN_DISTANCE:
					return manhattanDistance(iris1.getData(), iris2.getData());
			
				case CHEBYSHEV_DISTANCE:
					return chebyshevDistance(iris1.getData(), iris2.getData());
		
				default:
					throw new Exception("Incorrect Algorithm Choice");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return -99;
		}
		
	}
	
	/**
	 * Euclidean Distance
	 * @param pt1 Array of double to compare
	 * @param pt2 Array of double to compare
	 * @return Distance
	 * @author Bunn (psudeocode)
	 */
	
	public double euclideanDistance(double[] pt1, double[] pt2) {
		double sum = 0, d;
		for (int i = 0; i < pt1.length; i++) {
			d = pt1[i] - pt2[i];
			sum = sum + d * d;
		}
		return Math.sqrt(sum);
	}
	
	/**
	 * Manhattan Distance
	 * @param pt1 Array of double to compare
	 * @param pt2 Array of double to compare
	 * @return Distance
	 * @author Bunn (psudeocode)
	 */
	
	public double manhattanDistance(double[] pt1, double[] pt2) {
		double sum = 0, d;
		for (int i = 0; i < pt1.length; i++) {
			d = Math.abs(pt1[i] - pt2[i]);
			sum = sum + d;
		}
		return sum;
	}
	
	/**
	 * Chebyshev Distance
	 * @param pt1 Array of double to compare
	 * @param pt2 Array of double to compare
	 * @return Distance
	 * @author Bunn (psudeocode)
	 */
	
	public double chebyshevDistance(double[] pt1, double[] pt2) {
		double result = 0, d;
		for (int i = 0; i < pt1.length; i++) {
			d = Math.abs(pt1[i] - pt2[i]);
			result = Math.max(result, d);
		}
		return result;
	}
		
}
