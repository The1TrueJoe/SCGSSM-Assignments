/*
 * Write the code to create a Product class which maintains a description and a price.  
 * Write both the header and cpp files. 
 * Provide a default constructor which sets price to 0.0 and description to ‘not available’. 
 * Provide accessor  and mutator member functions for the description and the price.
 */

#include <string>              

using namespace std;   

class Product {
    public:
        // Constructor
        Product();
        Product(string, double);

        // Mutator
        void setPrice(double);
        void setDescription(string);

        // Accessor
        double getPrice();
        double getDescription();

    private:
        // Price
        double price;

        // Description
        string description;

};