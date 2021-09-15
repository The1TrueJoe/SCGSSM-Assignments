/*
 * Write the code to create a Product class which maintains a description and a price.  
 * Write both the header and cpp files. 
 * Provide a default constructor which sets price to 0.0 and description to ‘not available’. 
 * Provide accessor  and mutator member functions for the description and the price.
 */

#include "Product.h"

#include <string>
#include <iostream>

using namespace std;

int main() {   
    string descript = "GE Washing machine";   
    double cost = 256.59;   
    
    Product p (descript, cost);   
    
    cout <<  p.getDescription() << " $" << p.getPrice() << endl;   
    return 0;
    
}
