#include <string>              

using namespace std;     

// Class definition
class GradeBook {
    public:
        // Constructor
        GradeBook( string );

        // Set the course name
        void setCourseName( string );  

        // Return the course name
        string getCourseName();

        // Display welcome message
        void displayMessage(); 

        // Input grades
        void inputGrades();    

        // Get the maximum of three values
        int maximum( int, int, int );

        // Display grades     
        void displayGradeReport();

        // Get the class average
        void determineClassAverage();
    
    private:
        // Name of the course
        string courseName;    

        // Max grade
        int maximumGrade;

};