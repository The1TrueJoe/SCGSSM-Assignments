#include <cstdlib>
#include <iostream> using namespace std;

/* This program inputs two numbers x and y and outputs their sum */

int main( ) {
    int x, y;

    std::cout << “Please enter two numbers: ”;
    std::cin >> x >> y;                      // input x and y
    
    int sum = x + y ;                            // compute the sum
    
    std::cout << “Their sum is “ << sum << std::endl;
    
    return EXIT_SUCCESS;   / terminated successfully
    
}               