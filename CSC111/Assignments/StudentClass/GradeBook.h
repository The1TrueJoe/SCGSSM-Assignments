#include <string>              

using namespace std;     

// Class definition
class GradeBook {
    public:
        // Constructor
        GradeBook();

        // Set the course name
        void setCourseName( string );  

        // Return the course name
        string getCourseName();

        // Display welcome message
        void displayMessage(); 

        // Input grades
        int * inputGrades(int);    

        // Get the maximum of three values
        int maximum( int, int, int );

        // Display grades     
        void displayGradeReport();

        // Get the class average
        int determineClassAverage(int[]);

        // Get letter grade
        char getLetterGrade();
    
    private:
        // Name of the course
        string courseName;    

        // Max grade
        int maximumGrade;

        // Average
        double average;

        // Letter grade
        char letter_grade;

        // Grades
        int * all_grades;

};