// a. display all of the scores in the vector
void displayVector(const vector <int> &grades) {
    for (size_t i = 0; i < grades.size(); i++) {
        cout << grades[i] << endl;

    }
}

// b. return the sum of the values in the vector
int sumGrades(const vector<int> &grades) {
    int sum = 0;
    for (size_t i = 0; i < grades.size(); i++) {
        sum += grades[i];

    }
}

// c. curve the grades in the vector by adding a bonus value
void curveGrade (const vector<int> &grades) {
    int largest = 0;

    for (size_t i = 0; i < grades.size(); i++) {
        if (grades[i] > largest) {
            largest = grades[i];

        }
    }

    //Applying the curve
    int curve = 100 - largest;

    for (size_t i = 0; i < grades.size(); i++) {
        grades[i] = grades[i] + curve;

    }
}

// Main
int main(){

    // Name
    string course_name;
    cin >> course_name;

    // Grades
    vector<int> grades (10);

    // Fill the elements
    for (int i = 0; i < grades.size(); i++) {
        cout << "Enter grade ";
        cin >> grades[i];

    }

    // Print the vector
    displayVector(grades);

    // Summing and display it
    sumGrades(grades);
    displayVector(grades);

    // Make a copy
    vector<int> grades2 (10);
    grades2 = grades;

    // Curve
    curveGrades(grades);

    // Print
    cout << courseName << "Grades " << endl;
    displayVector(grades);

    // Outputting vector without curve
    displayVector(grades2);

    return 0;

}