/*
 * Write the code to create a Product class which maintains a description and a price.  
 * Write both the header and cpp files. 
 * Provide a default constructor which sets price to 0.0 and description to ‘not available’. 
 * Provide accessor  and mutator member functions for the description and the price.
 */

#include <string>
#include <iostream>

#include "GradeBook.h"

using namespace std;

// Constructor
Product::Product() {
    setPrice(0.0);
    setDescription("not available");

}

// Constructor
Product::Product(string m_description, double m_price) {
    setPrice(m_price);
    setDescription(m_description);

}

// Set Price
void Product::setPrice(double m_price) {
    price = m_price;

}

// Set description
void Product::setDescription(string m_description) {
    description = m_description;

}

// Get Price
double Product::getPrice() {
    return price;

}

// Get Description
string Product::getDescription() {
    return description;

}

