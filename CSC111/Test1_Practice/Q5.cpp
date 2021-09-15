/*
 * 5.  Write the code for main.cpp  
 * to ask the user to enter a positive integer.  
 * Then display a triangle of asterisks formed from printing 
 * that number of asterisks on the first line, then reducing 
 * the number on the following lines until the triangle is fully formed. 
 */

#include <iostream>

using namespace std;

int main() {
    cout << "Enter Number" ;  
    int num;
    cin >> num;
    
    for (int i = num; i > 0; i--) {
        for (int x = 0; x < i; x++) {
            cout << "*";
            
        }
        
        cout << endl;
    }

}
