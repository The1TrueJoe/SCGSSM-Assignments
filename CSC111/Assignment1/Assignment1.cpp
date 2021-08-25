//
// Created by Joey Telaak on 8/20/21.
//

#include <cstdlib>
#include <iostream>

/* This program inputs three numbers and outputs their sum */

int main( ) {
    // Variables
    int x;
    int y;
    int z;

    // Enter x
    std::cout << "Please enter x: ";
    std::cin >> x;

    // Enter y
    std::cout << "Please enter y: ";
    std::cin >> y;

    // Enter z
    std::cout << "Please enter z: ";
    std::cin >> z;

    // Calculate sum
    int sum = x + y + z;                           

    // Print sum
    std::cout << "x + y + z = " << sum << std::endl;

    // Terminate
    return EXIT_SUCCESS;

}               