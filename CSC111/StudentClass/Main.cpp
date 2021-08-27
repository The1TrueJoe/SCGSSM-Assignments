// Assignment Instructions
// Write a Student class in which each student maintains a first and last name and a course grade
// Provide accessor and mutator methods to update the student's name and course grade.
// Use chapter 3.1  to 3.6 to create a Student class that is similar to the Gradebook class 

#include <iostream>
#include <iomanip>
#include <string>

#include "GradeBook.h"
#include "Student.h"

using namespace std;

void main() {
    // Input the number of studetns to track
    cout << "How many students would you like to create>" << endl;
    int students;
    cin >> students;
    Student * students[];

    // Work thorugh all studetns
    for (int i = 0; i < students; i++) {
        // Setup strings
        string first, last;

        // Get first name
        cout << "What is student " << i << "'s first name?" << endl;
        cin >> first;

        // Get last name
        cout << "What is student " << i << "'s last name?" << endl;
        cin >> last;

        // Get num of classes
        cout << "How many classes is student " << i << " taking?" << endl;
        int classes;
        cin >> classes;

        // Setup array
        GradeBook * grades[classes];

        // Create x classes
        for (int x = 0; x < classes; x++) {
            grades[x] = new GradeBook();

        }

        // Setup student
        students[i] = new Student(first, last, classes);
    }

    // Print all students
    for (int i = 0; i < sizeof(students); i++) {
        students[i].displayMessage();

    }


}