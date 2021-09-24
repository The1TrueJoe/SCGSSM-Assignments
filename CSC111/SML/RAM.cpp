#include "RAM.h"
#include "CPU.h"

#include <array>
#include <string>

using namespace std;

RAM::RAM() {

}

void RAM::LoadFile(string file_location) {
    

}

// Reset the ram with a new array
void RAM::SET(array<int, 100> new_memory) {
    RAM::memory = new_memory;

}
