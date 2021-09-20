#include "RAM.h"

#include <array>
#include <string>

RAM::RAM() {

}

RAM::RAM(string file_location) {
    CPU::memmory = CPU::LoadFile(file_location);

}

