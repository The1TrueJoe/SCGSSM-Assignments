#include <iostream>
#include "GradeBook.h"

using namespace std;

int main() {
    cout << "Enter the name of the course ";
    string name;
    cin >> name;

    GradeBook myGradeBook1(name);
    GradeBook myGradeBook2("Robotics");

    cout << myGradeBook1.getCourseName()<< endl;
    cout << myGradeBook2.getCourseName() <<endl;

    return 0;

}