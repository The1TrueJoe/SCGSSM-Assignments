#include "CPU.h"

#include <iostream>

using namespace std;

void CPU::Start() {  
    
}

// OP
int CPU::OP(int op_code, int memmory_address) {
    switch (op_code) {
        case CPU::READ:         return OP_READ(memmory_address);
        case CPU::WRITE:        return OP_WRITE(memmory_address);
        case CPU::LOAD:         return OP_LOAD(memmory_address);
        case CPU::STORE:        return OP_STORE(memmory_address);
        case CPU::ADD:          return OP_ADD(memmory_address);
        case CPU::SUB:          return OP_SUB(memmory_address);
        case CPU::DIV:          return OP_DIV(memmory_address);
        case CPU::MULT:         return OP_MULT(memmory_address);
        case CPU::BRANCH:       return OP_BRANCH(memmory_address);
        case CPU::BRANCHNEG:    return OP_BRANCHNEG(memmory_address);
        case CPU::BRANCHZERO:   return OP_READ(memmory_address);
        case CPU::HALT:         return OP_HALT(memmory_address);

    }

}

// Read a word from the keyboard into the specified memory location
int CPU::OP_READ(int memmory_address) {

}

// Write a word from a specified memory location onto the screen
int CPU::OP_WRITE(int memmory_address) {
    cout << memmory.Load(memmory_address) << endl;

}      
        
// Load a word from a specified location in memory into the accumulator 
int CPU::OP_LOAD(int memmory_address) {

}

// Store a word from the accumulator into a specified location in memory
int CPU::OP_STORE(int memmory_address) {

}  
        
// Add a word from a specified location in memory to the accumulator
int CPU::OP_ADD(int memmory_address) {

}

// Subtract a word from a location in memory from the accumulator
int CPU::OP_SUB(int memmory_address) {

}     

// Divide a word from a location into the value in the accumulator
int CPU::OP_DIV(int memmory_address) {

}

// Multiply a word from a location into the value in the accumulator
int CPU::OP_MULT(int memmory_address) {

}

// Branch to the specified location in memory
int CPU::OP_BRANCH(int memmory_address) {

}

// Branch to the specified location if the accumulator is negative
int CPU::OP_BRANCHNEG(int memmory_address) {

}

// Branch to the specified location if the accumulator is zero 
int CPU::OP_BRANCHZERO(int memmory_address) {

}
        
// Halt
int CPU::OP_HALT(int memmory_address) {

}     