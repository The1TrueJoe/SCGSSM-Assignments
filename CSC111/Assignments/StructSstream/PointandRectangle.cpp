/*
 * Joseph Telaak
 * Assignment due 9/3/21
 *
 * Purpose: Uses structs and a sstream in order to test if two
 *              user-inputted rectangles can be placed inside each other
 *
 * Honor Code: On my honor, I have neither given nor received unauthorized help on this assignment.
 * 
 * +--------------------> X axis
 * |
 * |    (X,Y)      (X+W, Y)
 * |    +--------------+
 * |    |              |
 * |    |              |
 * |    |              |
 * |    +--------------+
 * v    (X, Y+H)     (X+W,Y+H)
 * 
 * Y axis
 */

#include <iostream>
#include <sstream>

using namespace std;

// Point struct
struct Point {
    int x;      // X Value
    int y;      // Y Value

};


// Rectangle struct
struct Rectangle {
    int length;               // Rectangle length
    int width;                // Rectangle width
    Point upper_left_corner;    // Rectangle corner

};

int main() {
    // String stream
    stringstream ss;

    // Rectangles
    Rectangle rect_1;
    Rectangle rect_2;

    // Rectangle 1 

    // Length
    ss << "Enter Rectangle 1 Length" << endl;
    ss >> rect_1.length;

    // Width
    ss << "Enter Rectangle 1 Width" << endl;
    ss >> rect_1.width;

    // Upper left x
    ss << "Enter Rectangle 1 Upper Left x" << endl;
    ss >> rect_1.upper_left_corner.x;

    // Upper left y
    ss << "Enter Rectangle 1 Upper Left y" << endl;
    ss >> rect_1.upper_left_corner.y;

    // Rectangle 2 

    // Length
    ss << "Enter Rectangle 2 Length" << endl;
    ss >> rect_2.length;

    // Width
    ss << "Enter Rectangle 2 Width" << endl;
    ss >> rect_2.width;

    // Upper left x
    ss << "Enter Rectangle 2 Upper Left x" << endl;
    ss >> rect_2.upper_left_corner.x;

    // Upper left y
    ss << "Enter Rectangle 2 Upper Left y" << endl;
    ss >> rect_2.upper_left_corner.y;

    if (inside(rect_1, rect_2)) {
        ss << "The rectangle is not entirely inside the other" << endl;

    } else {
        ss << "The rectangle is not entirely inside the other" << endl;

    }

}

// Test if the overlap
bool inside(const Rectangle & rect1, const Rectangle & rect2) {
    bool x_overlap = within(rect1.upper_left_corner.x, rect2.upper_left_corner.x, rect2.upper_left_corner.x + rect2.length) ||
                     within(rect2.upper_left_corner.x, rect1.upper_left_corner.x, rect1.upper_left_corner.x + rect1.length);

    bool y_overlap = within(rect1.upper_left_corner.y, rect2.upper_left_corner.y, rect2.upper_left_corner.y + rect2.width) ||
                     within(rect2.upper_left_corner.y, rect1.upper_left_corner.y, rect1.upper_left_corner.y + rect1.width);

    return x_overlap && y_overlap;

}

// Checks if value is within range (simple helper method to shorten code)
bool within(int value, int min, int max) {
    return (value >= min) && (value <= max);

}