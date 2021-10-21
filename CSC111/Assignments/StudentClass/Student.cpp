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

// Constructor
Student::Student(string first_name, string last_name, GradeBook * classes) {
    first = first_name;
    last = last_name;
    grades = classes;

}

// Print out student info
void Student::displayMessage() {
    // Print name
    cout << "Student: " << first << last << endl;

    // Print courses
    for (int i = 0; i < sizeof(grades); i++) {
        grades[i].displayGradeReport();

    }

}

// Set the first name
void Student::setFirst(string first_name) {
    first = first_name;

}

// Set the last name
void Student::setLast(string last_name) {
    last = last_name;
    
}

// Get the first name
string Student::getFirst() {
    return first;

}

// Get the last name
string Student::getLast() {
    return last;

}

// Return a course
GradeBook Student::getClass(int course) {
    return grades[course];

}