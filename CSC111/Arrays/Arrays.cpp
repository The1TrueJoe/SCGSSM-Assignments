/*
Create a C++ application
Use funtions to perform the following tasks:
Create an array of 20 integer values using the <array> class.  
Create an array of 20 double values using the built-in array allocation.  
Generate random integer values from 1 to 100 and store them in each of the arrays.
Display the contents of each array.
Use <algorithm> to sort both array.
Display the sorted arrays.
Use <algortihm> to search each array for a value entered by the user.
Test the code by searching for a value greater than 100 in each array.
Test the code by searching for a value that you know exists in each array.
Upload the code and the output from your tests.
*/

#include <array>
#include <cstddef>
#include <random>
#include <iostream>
#include <vector>
#include <iterator>

using namespace std;

int main() {
    // Setup
    array<int, 20> included = {};   // Array size 20
    double built_in[20] = {};       // Array size 20

    // Init
    for (size_t i = 0; i < included.size(); ++i) {
        included[i] = rand() % 100 + 1;

    }
    
    for (size_t i = 0; i < sizeof(built_in)/sizeof(built_in[0]); ++i) {
        double f = (double)rand() / RAND_MAX;
        built_in[i]=  0 + f * (100 - 0);
        
    }

    // Display
    cout << "Included (int) Size: " << included.size() << " - ";
    for (size_t i = 0; i < included.size();  ++i) { cout << included[i] << " "; } cout << endl; cout << endl;
    
    cout << "Built In (double) Size: " << sizeof(built_in)/sizeof(built_in[0]) << " - ";
    for (size_t i = 0; i < sizeof(built_in)/sizeof(built_in[0]); ++i) { cout << built_in[i] << " "; } cout << endl;

    // Sorting algorthims
    sort(included.begin(), included.end());
    sort(begin(built_in), end(built_in));

    // Display
    cout << "Included (int) Size: " << included.size() << " - ";
    for (size_t i = 0; i < included.size();  ++i) { cout << included[i] << " "; } cout << endl; cout << endl;
    
    cout << "Built In (double) Size: " << sizeof(built_in)/sizeof(built_in[0]) << " - ";
    for (size_t i = 0; i < sizeof(built_in)/sizeof(built_in[0]); ++i) { cout << built_in[i] << " "; } cout << endl;

    // Search
    int num;
    cout << "Number to search:" << endl;
    cin >> num;

    vector<int> myvector(included.begin(), included.end());
    vector<int>::iterator it;

    it = find(myvector.begin(), myvector.end(), search);

    if (it != myvector.end()) {
        cout << "Found in included rray" << endl;

    } else {
        cout << "Not found in included array" << endl;

    }

    double* p = find(begin(built_in), end(built_in), search);

    if (p != end(built_in)) {
        cout << "Found in built in array" << endl;

    } else {
        cout << "Not found in built in array" << endl;

    }

    num = 101;

    vector<int> myvector(included.begin(), included.end());
    vector<int>::iterator it;

    it = find(myvector.begin(), myvector.end(), search);

    if (it != myvector.end()) {
        cout << "Found in included rray" << endl;

    } else {
        cout << "Not found in included array" << endl;

    }

    double* p = find(begin(built_in), end(built_in), search);

    if (p != end(built_in)) {
        cout << "Found in built in array" << endl;

    } else {
        cout << "Not found in built in array" << endl;

    }

    return 0;

    num = included[0];

    vector<int> myvector(included.begin(), included.end());
    vector<int>::iterator it;

    it = find(myvector.begin(), myvector.end(), search);

    if (it != myvector.end()) {
        cout << "Found in included rray" << endl;

    } else {
        cout << "Not found in included array" << endl;

    }

    double* p = find(begin(built_in), end(built_in), search);

    if (p != end(built_in)) {
        cout << "Found in built in array" << endl;

    } else {
        cout << "Not found in built in array" << endl;

    }

    return 0;
    

    
}