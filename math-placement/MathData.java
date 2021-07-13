import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

class MathData {

	class Student {
		private int highschool;
		private double placement_score;
		private double[] class_grades;
		private Course course_placement;
		private Course course_actual;

		private double grade_average;

		public final static int ALGEBRA1_INDEX = 0;
		public final static int GEOMETRY_INDEX = 1;
		public final static int ALGEBRA2_INDEX = 2;
		public final static int PRECAL_INDEX   = 3;
		public final static int PLACEMENT_INDEX= 4;

		public static int MIN_INDEX = ALGEBRA1_INDEX;
		public static int MAX_INDEX = PLACEMENT_INDEX;

		public Student(ArrayList<Double> data, String course_type) {
			highschool = (int) Math.round(data.get(0));
			placement_score = data.get(data.size() - 2);
			course_actual = new Course(course_type, data.get(data.size() - 1));
			class_grades = new double[PRECAL_INDEX + 1];

			for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
				class_grades[i] = data.get(i + 1);
			}

		}
		public Student(int highschool, double placement_score, double[] class_grades, Course course_actual) {
			this.highschool = highschool;
			this.placement_score = placement_score;
			this.class_grades = class_grades;
			this.course_actual = course_actual;

		}

		private void adjustScores() {
			for (int grade : class_grades) {
				if (grade == Course.COURSE_NOTCOMPLETED) {
					grade = 0;
				} else if (grade == Course.COURSE_INPROGRESS) {
					grade = grade_average;
				}
			}
		}

		public double calcAverage() {
			double average = 0;
			int count;

			for (int grade : class_grades) {
				if (!(grade <= 0)) {
					average += grade;
					count++;
				}
			}

			average = Math.round(average / count);
			grade_average = average;
			return average;
		}

		public void placeInCourse(Course course) { course_placement = course; }

		public boolean checkPlacement() {
			if (course_actual.getCourseNumber() == course_placement.getCourseNumber()) {
				return true;
			} else {
				return false;
			}
		}

		public boolean checkPlacement(String course) {
			if (course_actual.getCourseCode().equalsIgnoreCase(course)) {
				return true;
			} else {
				return false;
			}
		}

		public boolean clearPlacement() { course_actual = new Course(); }

		public int getHighSchool() { return highschool; }
		public double getPlacementScore() { return placement_score; }
		public double[] getGrades() { return class_grades; }
		public double getGrades(int index) { return class_grades[index]; }
		public Course getActualCourse() { return course_actual; }
		public Course getPlacedCourse() { return course_placement; }
	}

	class Course {

		private int course_number;
		private String course_prefix;
		private String course_code;

		public static int COURSE_NOTCOMPLETED = -100;
		public static int COURSE_INPROGRESS	  = -50;

		public Course(String course_code) {
			this.course_code = course_code;

			course_prefix = course_code.substring(0, 2);
			course_number = Integer.parseInt(course_code.substring(course_prefix.length() - 1));

		}

		public Course() {
			course_code = 0;
			course_prefix = "N/A";
			course_code = "N/A";
		}

		public int getCourseNumber() { return course_number; }
		public String getCoursePrefix() { retunrn course_prefix; }
		public String getCourseCode() { return course_prefix; }

	}

	class Classifier {

		private ArrayList<Student> students;
		private ArrayList<Student> average_students;

		public Classifier(ArrayList<Student> students) {
			this.students = students;

		}

		public ArrayList<Student> calcAverageStudents() {
			ArrayList<Student> averageStudent = new ArrayList<Iris>();
			Course currentClass = student.get(0).getActualClass();

			double[] data = new double[Student.MAX_INDEX];
			double count = 0;

			for (int i = 0; i < students.size(); i++) {
				if (!student.get(i).checkCoursePlacement(currentClass) || i == students.size()-1) {
					for (int x = 0; x < data.length; x++) { data[x] = data[x] / count; }

					averageStudent.add(new Student(data, irises.get(i-1).getActualCourse()));
					currentClass = students.get(i).getActualCourse();
					data = new double[Student.MAX_INDEX];
					count = 0;

				} else {
					for (int x = 0; x < data.length; x++) { data[x] += students.get(i).getGrade(x); }

					count++;
				}
			}

			average_students = averageStudent;
			return averageStudent;
		}

		/** To String */

		public String toString() {

			String string = "";

			for (Student i : students) {
				string += i + " ]\n";
			}

			string += " Averages \n";

			for (Student i : average_students) {
				string += i + " ]\n";
			}

			return string;
		}

		/** Clear all determined classifications */

		public void clearClassifications() {
			for (Student student : students) {
				student.clearClass();
			}
		}

		/** Set all determined classifications to the students's actual class*/

		public void setCorrectClassifications() {
			for (Student student : students) {
				student.setClass(student.getActualClass());
			}
		}

		/** Set every other students's determined class to the students's actual class */

		public void setHalfCorrectClassifications() {
			for (int i  = 0; i < students.size(); i++) {
				if (i % 2 != 0) {
					students.get(i).placeInCourse(students.get(i).getActualCourse());
				} else {
					students.get(i).placeInCourse(new Course());
				}
			}
		}

		/**
		 * Print the results of the classifications by checking if all irises were classified correctly
		 */

		public void printResults() {

			String currentClass = students.get(0).getActualClass();
			double correct = 0;
			double total = 0;

			for (int i = 0; i < students.size(); i++) {

				if (!students.get(i).checkClassification(currentClass)) {
					System.out.println("Students: " + students.get(i-1).getActualClass() + " Correct: " + correct + " Total: " + total + " Score: " + String.format("%,.2f", ((correct / total) * 100)));

					correct = 0;
					total = 0;
					currentClass = students.get(i).getActualClass();
				}

				if (students.get(i).checkClassification()) {
					correct++;
					total++;
				} else {
					total++;
				}

			}

			System.out.println("Students: " + students.get(students.size()-1).getActualClass() + " Correct: " + correct + " Total: " + total + " Score: " + String.format("%,.2f", ((correct / total) * 100)));
		}

		/**
		 * Attempt to classify the student
		 * @param method Method of distance calculation (Ex. {@link #EUCLIDEAN_DISTANCE})
		 * @return Classification (Automatically sets the student's determined class to its result)
		 */

		public Course classify(int method) {
			clearClassifications();
			Course classification = new Course();
			double prevtmp = 100, tmp;

			for (Student student : students) { // Run through all students

				System.out.println("Current Studenr: " + student);

				for (Student avg : average_students) { // Runs through each average student

					tmp = getDistance(method, student, avg); System.out.println("Distance from " + avg.getActualClass() + ": " + tmp); // Calculate distance

					if (prevtmp > tmp) { classification = avg.getActualCourse(); } // Set classification to the student with the lowest distance

					prevtmp = tmp;
				}

				System.out.println("Student Determined as " + classification);
				student.placeInCourse(classification);
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


	public static void main(String[] args) {
		MathData.Classifier studentclass = new MathData.Classifier(MathData.pickFile(), ",");

		System.out.println("\n\nEuclidean Distance");
		studentclass.clearClassifications();
		studentclass.classify(MathData.EUCLIDEAN_DISTANCE);
		studentclass.printResults();

		System.out.println("\n\nChebyshev Distance");
		studentclass.clearClassifications();
		studentclass.classify(MathData.CHEBYSHEV_DISTANCE);
		studentclass.printResults();

		System.out.println("\n\nManhattan Distance");
		studentclass.clearClassifications();
		studentclass.classify(MathData.MANHATTAN_DISTANCE);
		studentclass.printResults();

		System.out.println("Class Dump: \n" + studentclass);

	}

	// Utilities

	/** User a JFileChooser to pick a file */

	public static File pickFile() {

		JFileChooser chooser = new  JFileChooser();

		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();

		} else {
			return null;

		}
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

	/**
	 * Reads the data from the file in the format ("sepal_length","sepal_width","petal_length","petal_width","class")
	 * @param file The file to be read (Either specified or found using {@link #pickFile()}
	 * @param separationChar The character(s) used to separate the data points
	 * @return An ArrayList of all irises
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

				while (line.contains(separationChar) && startIndex != line.length()) {
					stopIndex = line.indexOf(separationChar);  // Change stopping index to the separation character
					section = line.substring(startIndex, stopIndex); // Pull section to read

					if (!section.isEmpty()) { data.add(Double.parseDouble(section)); } else { System.out.println("Line is empty"); }

					line = line.substring(stopIndex+1);
				}

				count++;
				studentData.add(new Student(data));

			}

			// Count amount of students and number of classes

			String currentClass = "";
			for (Student student : studentData) {
				if (!student.checkPlacement(currentClass)) { currentClass = student.getActualClass(); }
			}

			System.out.println("Data Import Finished " + count);
			return irisData;

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

		return null;
	}


}