#include <iostream>
#include <iomanip>
#include <string>

#include "GradeBook.h"

using namespace std;

// Constructor
GradeBook::GradeBook() {
    cout << "Enter course name" << endl;
    string name;
    cin >> name;

    setCourseName(name); 

    cout << "Enter number of grades" << endl;
    int size;
    cin >> size;

    all_grades = inputGrades(size);
    displayGradeReport();

}

// function to set the course name;
void GradeBook::setCourseName( string name ) {
    if(name.length() <= 25) {
        courseName = name;

    } else {
        courseName= name.substr(0,25);
        cout << "Name \"" << name << "\" exceeds maximum length (25).\n"
             << "Limiting course name to first 25 characters.\n" << endl;
             
    }

}

// Get the name of the course
string GradeBook::getCourseName() {
    return courseName;

}

// Print out the course banner
void GradeBook::displayMessage() {
    cout << "Welcome to the grade book for\n" << getCourseName() << "!\n" << endl;

}

// Print out the grades
void GradeBook::displayGradeReport() {
    // Title and Average
    cout << courseName << " Grade Report" << endl;
    cout << letter_grade + " Average: " << determineClassAverage(all_grades) << endl;

    // List all lines
    for (int i = 0; i < sizeof(all_grades); i++) {
        cout << all_grades[i] << endl;

    }
}

// Input grades
int * GradeBook::inputGrades(int size) {
    // Setup array
    int grade[size];

    // Enter grades
    for (int i = 0; i < size; i++) {
        cout << "Enter " << i << " grade: " << endl;
        cin >> grade[i];

    }

    // Return
    return grade;

}

// Get letter grade
char GradeBook::getLetterGrade() {
    return letter_grade;

}

// Compute average
int GradeBook::determineClassAverage(int grades[]) {
    // Setup variables
    int total;
    int gradeCounter;
    int grade;

    // Set variables
    total = 0;
    gradeCounter = sizeof(grades);

    // Sum grades
    for (int i = 0; i < gradeCounter; i++) {
        total = total + grades[i];

    }

    // Compute average
    if(gradeCounter != 0 ) {
        average = static_cast<double>(total)/gradeCounter;

        if (average >= 90) {
            letter_grade = 'A';
        } else if (average >= 80) {
            letter_grade = 'B';
        } else if (average >= 70) {
            letter_grade = 'C';
        } else if (average >= 60) {
            letter_grade = 'D';
        } else {
            letter_grade = 'F';
        }

        // Return average
        return average;

    } else {
        // Default
        return 0;

    }

}



