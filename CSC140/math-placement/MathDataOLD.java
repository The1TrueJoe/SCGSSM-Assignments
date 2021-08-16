import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;


public class MathData {

	
	class Student {
		
		private int highschool_code;  // Ignored int placement
		private double[] scores;
		private double average_score;
		private Course actual_course = new Course(); // To check accuracy
		private Course placed_course = new Course();
	
		public Student(int highschool_code, double[] scores, Course actual_course) {
			this.highschool_code = highschool_code;
			this.scores = scores;
			this.actual_course = actual_course;
			calcAverage();
		}
		
		public Student(double[] scores, Course actual_course) {
			this.highschool_code = -1;
			this.scores = scores;
			this.actual_course = actual_course;
			calcAverage();
		}
		
		public Student(ArrayList<Double> data) {
			String out = "";
			for (Double x : data) { out += x + " "; }
			System.out.println("Student: " + out);
			
			highschool_code = (int) Math.round(data.get(0));
			
			scores = new double[PLACEMENT_SCORE+1];
			
			for (int i = ALGERBRA1_GRADE; i < PRECALCULUS_GRADE; i++) {
				scores[i] = data.get(i+1);
			}
			
			scores[PLACEMENT_SCORE] = data.get(data.size()-3);
			actual_course = new Course((int)Math.round(data.get(data.size()-2)));
			calcAverage();
		}
		
		public int getHighschoolCode() { return highschool_code; } 
		
		public void placeInCourse(Course course) { placed_course = course; }
		public void clearCourse() { placed_course = new Course(); }
		public Course getActualCourse() { return actual_course; }
		public Course getPlacedCourse() { return placed_course; }
		
		/** @return Whether or not the placement aligns with the initial data; */
		public boolean checkCourse() {
			if (actual_course.getNumericCourseCode() == placed_course.getNumericCourseCode()) { 
				return true;
				
			} else {
				return false;
				
			}
		}
		
		/** @return Whether or not the placement aligns with the initial data; */
		public boolean checkCourse(Course course) {
			if (actual_course.getNumericCourseCode() == course.getNumericCourseCode()) { 
				return true;
				
			} else {
				return false;
				
			}
		}
		
		/** @return Whether or not the placement aligns with the initial data; */
		public boolean checkCourse(String course) {
			if (course.equalsIgnoreCase(actual_course.toString())) { 
				return true;
				
			} else {
				return false;
				
			}
		}
		
		/** @param index The index of the data (Use static finals) **/
		public double getScore(int index) { return scores[index]; }
		public double[] getScores() { return scores; }
		
		public double getAverage() { return average_score; }
		private void calcAverage() {
			double total = 0;
			double count = 0;
			
			for (double score : scores) {
				if (score == Course.IN_PROGRESS || score == Course.NOT_COMPLETED) {
					continue;
				}
				
				total += score;
				count++;
			}
			
			average_score = Math.round(total / count);
			adjustScores();
		}
		
		/** Adjusts scores for comparison (Do not calculate average afterwards) **/
		private void adjustScores() {
			for (int i = 0; i < scores.length; i++) {
				if (scores[i] == Course.IN_PROGRESS) {
					scores[i] = average_score;
				} else if (scores[i] == Course.NOT_COMPLETED) {
					scores[i] = 0;
				}
			}
		}
		
		public String toString() { 
			return "{School Code: " + highschool_code + ", Alg. 1 Grade: " + scores[ALGERBRA1_GRADE] + 
					", Geo. Grade: " + scores[GEOMETRY_GRADE] + ", Alg. 2 Grade: " + scores[ALGERBRA2_GRADE] + 
					", Pre-Calc. Grade: " + scores[PRECALCULUS_GRADE] + ", Placement Exam Score: " + scores[PLACEMENT_SCORE] + 
					", Course: " + actual_course.toString() + ", Placed Course: " + placed_course.toString() + "}";
		}

		// Indexes of certain data
		public static final int ALGERBRA1_GRADE 	= 0;
		public static final int GEOMETRY_GRADE		= 1;
		public static final int ALGERBRA2_GRADE		= 2;
		public static final int PRECALCULUS_GRADE 	= 3;
		public static final int PLACEMENT_SCORE 	= 4;
	}
	
	class Course {
		
		private String course_code_header;
		private String course_code;
		private int numeric_course_code;
		
		private int numberized_course_code;
	
		public Course(String course_code, String course_code_header) {
			this.course_code = course_code;
			this.course_code_header = course_code_header;
			this.numeric_course_code = getNumericCourseCode(course_code, course_code_header);
		}
		
		public Course(String course_code) {
			this.course_code = course_code;
			this.course_code_header = course_code.substring(0,2);
			this.numeric_course_code = getNumericCourseCode(course_code, course_code_header);
		}
		
		public Course(int numeric_course_code) {
			this.course_code = "MAT" + numeric_course_code;
			this.course_code_header = "MAT";
			this.numeric_course_code = numeric_course_code;
		}
		
		public Course() {
			this.course_code = "N/A";
			this.course_code_header = "N/A";
			this.numeric_course_code = 0;
		}
		
		public String getCourseCodeHeader() { return course_code_header; }
		public String getCourseCode() { return course_code; }
		public int getNumberizedCourseCode() { return numberized_course_code; }
		public int getNumericCourseCode() { return numeric_course_code; }
		
		private int getNumericCourseCode(String course_code, String course_code_header) {
			int numberized_course_code = -99;
			
			if (course_code.substring(0, course_code_header.length()-1).equalsIgnoreCase(course_code_header)) {
				try {
					numberized_course_code = Integer.parseInt(course_code.substring(course_code_header.length()));
					
				} catch (NumberFormatException e){
					new Exception("Course Code has not been added correctly {" + 
									course_code.substring(course_code_header.length()) +"} {" + course_code + "}").printStackTrace();
					
				}
			
			} else {
				try {
					numberized_course_code = Integer.parseInt(course_code);
					
				} catch (NumberFormatException e) {
					new Exception("Incorrect Formatting {" + course_code +"}").printStackTrace();;
					
				}
			}
			
			return numberized_course_code;
			
		}
		
		public int getNumberizedCourseCode(int[] course_level_list) {
			for (int i = 0; i < course_level_list.length; i++) {
				if (course_level_list[i] == numeric_course_code) {
					return i;
				}
			} 
			
			return -99;
		}
		
		public String toString() { return course_code; }
		
		public static final int IN_PROGRESS = -100;
		public static final int NOT_COMPLETED = 0;
	}

	ArrayList<Student> students;
	ArrayList<Student> averages;
	
	// Distance Calculation Types
	
	public static final int EUCLIDEAN_DISTANCE = 0;
	public static final int MANHATTAN_DISTANCE = 1;
	public static final int CHEBYSHEV_DISTANCE = 2;
	
	// ***************************************** CONSTRUCTOR **************************************
	
	public MathData(File file, String separationChar) {
		students = readData(file, separationChar);
		averages = getAverages();
	}
		
	public MathData(ArrayList<Student> students) {
		this.students = students;
		averages = getAverages();
	}
		
	public MathData() {
		students = readData(pickFile(), ",");
		averages = getAverages();	
	}
		
	// ***************************************** MAIN *********************************************
		
	public static void main(String[] args) {
		MathData studentClass = new MathData(MathData.pickFile(), ",");
			
		ArrayList<Student> x = studentClass.getStudents();
		
		for (Student i : x) {
			System.out.println(i);
		}
			/*
			System.out.println("\n\nEuclidean Distance");
			studentClass.clearPlacedCourse();
			studentClass.classify(MathData.EUCLIDEAN_DISTANCE);
			studentClass.printResults();
			
			System.out.println("\n\nChebyshev Distance");
			studentClass.clearPlacedCourse();
			studentClass.classify(MathData.CHEBYSHEV_DISTANCE);
			studentClass.printResults();
			
			System.out.println("\n\nManhattan Distance");
			studentClass.clearPlacedCourse();
			studentClass.classify(MathData.MANHATTAN_DISTANCE);
			studentClass.printResults();
			
			System.out.println("Class Dump: \n" + studentClass);
			*/
			
		}
	
	// ***************************************** MISC UTILITIES ***********************************
	
		public String toString() {
			
			String string = "";
			
			for (Student i : students) {
				string += i + " ]\n";
			}
			
			string += " Averages \n";
			
			for (Student i : averages) {
				string += i + " ]\n";
			}
			
			return string;
		}
		
		/*
		 * Print the results of the classifications by checking if all students were classified correctly
		 */
		
		public void printResults() {
			
			Course currentCourse = students.get(0).getActualCourse();
			double correct = 0;
			double total = 0;
			
			for (int i = 0; i < students.size(); i++) {
				
				if (!students.get(i).checkCourse(currentCourse)) { 
					System.out.println("Student: " + students.get(i-1).getActualCourse() + " Correct: " + correct + " Total: " + total + " Score: " + String.format("%,.2f", ((correct / total) * 100)));
					
					correct = 0;
					total = 0;
					currentCourse = students.get(i).getActualCourse(); 
				} 
				
				if (students.get(i).checkCourse()) { 
					correct++; 
					total++;
				} else {
					total++;
				}
			}
			
			System.out.println("Student: " + students.get(students.size()-1).getActualCourse() + " Correct: " + correct + " Total: " + total + " Score: " + String.format("%,.2f", ((correct / total) * 100)));
		}
		
		/** Clear all determined classifications */
		
		public void clearPlacedCourse() {
			for (Student student : students) {
				student.clearCourse();
			}
		}
		
		/** Set all determined classifications to the Student's actual class*/
		
		public void setCorrectClassifications() {
			for (Student student : students) {
				student.placeInCourse(student.getActualCourse());
			}
		}
		
		/** Set every other Student's determined class to the Student's actual class */
		
		public void setHalfCorrectClassifications() {
			for (int i  = 0; i < students.size(); i++) {
				if (i % 2 != 0) {
					students.get(i).placeInCourse(students.get(i).getActualCourse());
				} else {
					students.get(i).placeInCourse(new Course());
				}
			}
		}
		
		public ArrayList<Student> getStudents() { return students; }
		
	
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
		 * @return An ArrayList of all students
		 */
		
		public ArrayList<Student> readData(File file, String separationChar) {
			
			try {
				
				System.out.println("Importing File Data");
				
				ArrayList<Student> studentData = new ArrayList<Student>();
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
					
					while (line.contains(separationChar) || startIndex == line.length()) {
						stopIndex = line.indexOf(separationChar);  // Change stopping index to the separation character
						section = line.substring(startIndex, stopIndex); // Pull section to read
						
						if (!section.isEmpty()) { 
							if (section.equalsIgnoreCase("IP")) {
								data.add((double) Course.IN_PROGRESS);
							} else if (section.equalsIgnoreCase("NC")) {
								data.add((double) Course.NOT_COMPLETED);
							} else {
								data.add(Double.parseDouble(section)); 
							}
		
						} else { 
							System.out.println("Line is empty"); 
						}
						
						line = line.substring(stopIndex+1);
					}
					
					count++;
					studentData.add(new Student(data));
					
				}
				
				return studentData;
				
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
		 * Calculates the average Student of each class (Assumes data has already been normalized)
		 */
		
		public ArrayList<Student> getAverages() {
			
			ArrayList<Student> averageStudent = new ArrayList<Student>();
			Course currentClass = students.get(0).getActualCourse();
			double[] data = new double[Student.PLACEMENT_SCORE];
			double count = 0;
			
			for (int i = 0; i < students.size(); i++) {
				if (!students.get(i).checkCourse(currentClass) || i == students.size()-1) {
					for (int x = 0; x < data.length; x++) { data[x] = data[x] / count; }
				
					averageStudent.add(new Student(data, students.get(i-1).getActualCourse()));
					currentClass = students.get(i).getActualCourse();
					data = new double[Student.PLACEMENT_SCORE];
					count = 0;
					
				} else {
					for (int x = 0; x < data.length; x++) { data[x] += students.get(i).getScore(x); }
					
					count++;
				}
			}
			
			return averageStudent;
			
		}
		
		/**
		 * Attempt to classify the iri
		 * @param method Method of distance calculation (Ex. {@link #EUCLIDEAN_DISTANCE})
		 * @return Classification (Automatically sets the Student's determined class to its result)
		 */

		public Course classify(int method) {
			clearPlacedCourse();
			Course classification = new Course();
			double prevtmp = 100, tmp;
			
			for (Student Student : students) { // Run through all students
				
				System.out.println("Current Student: " + Student);
				
				for (Student avg : averages) { // Runs through each average Student
		
					tmp = getDistance(method, Student, avg); System.out.println("Distance from " + avg.getActualCourse() + ": " + tmp); // Calculate distance
					
					if (prevtmp > tmp) { classification = avg.getActualCourse(); } // Set classification to the Student with the lowest distance
					
					prevtmp = tmp;
				}
				
				System.out.println("Student Determined as " + classification);
				Student.placeInCourse(classification);
			}
			
			return classification;
		}
		
		/**
		 * Get the distance between two students
		 * @param method Method of distance calculation to use (Use {@link #MANHATTAN_DISTANCE}, {@link #CHEBYSHEV_DISTANCE}, or {@link #EUCLIDEAN_DISTANCE})
		 * @param Student1 Student 1
		 * @param Student2 Student 2 (Ex. average Student)
		 * @return Distance
		 */
		
		public double getDistance(int method, Student Student1, Student Student2) {
			try {
				switch (method) {
				
					case EUCLIDEAN_DISTANCE:
						return euclideanDistance(Student1.getScores(), Student2.getScores());
				
					case MANHATTAN_DISTANCE:
						return manhattanDistance(Student1.getScores(), Student2.getScores());
				
					case CHEBYSHEV_DISTANCE:
						return chebyshevDistance(Student1.getScores(), Student2.getScores());
			
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
