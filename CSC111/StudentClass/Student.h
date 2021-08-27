// Assignment Instructions
// Write a Student class in which each student maintains a first and last name and a course grade
// Provide accessor and mutator methods to update the student's name and course grade.
// Use chapter 3.1  to 3.6 to create a Student class that is similar to the Gradebook class 

#include <string>   
#include <GradeBook.h>           

using namespace std;     

class Student {
    public:
        // Default Constructot
        Student();

        // Constructor
        Student(string, string, GradeBook *);

        // First name
        void setFirst(string);

        // Last name
        void setLast(string);

        // Get first
        string getFirst();

        // Get last
        string getLast();

        // Get a book
        GradeBook getClass(int);

        // Print student
        void displayMessage();


    private:
        // Classes
        GradeBook * grades;

        // First name
        string first;

        // Last name 
        string last;

};