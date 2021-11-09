#include "RAM.h"

#include <array>
#include <string>
#include <fstream>
#include <iostream>
#include <sstream>

using namespace std;

RAM::RAM() {

}

/**
 * @brief load the memmory from a file
 * 
 * @param file_location 
 */

void RAM::LoadFile(string file_location) {
    // Setup vars
    string line;
    int memory_byte;

    // Memory array
    array<int, 100> new_memory;

    // File stream
    ifstream myfile (file_location);

    // While file is open
    if (myfile.is_open()) {
        // Current line
        int line_count = 0;

        // While a line exists
        while(!myfile.eof()) {
            // Clear variables
            line = "";
            memory_byte = 0;

            // Read the line
            getline(myfile, line);

            // Format as int
            stringstream obj;
            obj << line;
            obj >> memory_byte;

            // Assign to memory array
            new_memory[line_count] = memory_byte;

            // Increment line count
            line_count += 1;

        }

        // Close
        myfile.close();
        
    }
}

/**
 * @brief reset the memory with an array
 * 
 * @param new_memory array of new memory
 */
void RAM::SET(array<int, 100> new_memory) {
    RAM::memory = new_memory;

}
