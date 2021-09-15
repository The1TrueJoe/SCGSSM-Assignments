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
