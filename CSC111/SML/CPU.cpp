#include "CPU.h"

#include <iostream>

using namespace std;

void CPU::Start(array<int, 100> new_memory) {  
    memory.SET(new_memory);

    InstructionPointer = 0;
    Accumulator = 0;

    int starting_address = 0;

    while (InstructionPointer != CPU::HALT) {
        InstructionPointer = memory.Load(starting_address);

        OP(InstructionPointer, InstructionPointer + 1);

        InstructionPointer = memory.Load(InstructionPointer + 2);

    }
}

// OP
int CPU::OP(int op_code, int memory_address) {
    switch (op_code) {
        case CPU::READ:         OP_READ(memory_address);
        case CPU::WRITE:        OP_WRITE(memory_address);
        case CPU::LOAD:         OP_LOAD(memory_address);
        case CPU::STORE:        OP_STORE(memory_address);
        case CPU::ADD:          OP_ADD(memory_address);
        case CPU::SUB:          OP_SUB(memory_address);
        case CPU::DIV:          OP_DIV(memory_address);
        case CPU::MULT:         OP_MULT(memory_address);
        case CPU::BRANCH:       OP_BRANCH(memory_address);
        case CPU::BRANCHNEG:    OP_BRANCHNEG(memory_address);
        case CPU::BRANCHZERO:   OP_READ(memory_address);
        case CPU::HALT:         return CPU::HALT;

        default: return CPU::THROW_ERR;

    }

    return 0;

}

// Read a word from the keyboard into the specified memory location
void CPU::OP_READ(int memory_address) {
    int in;
    cout << "Enter word" << endl;

    cin >> in;
    memory.Store(memory_address, in);

}

// Write a word from a specified memory location onto the screen
void CPU::OP_WRITE(int memory_address) {
    cout << memory.Load(memory_address) << endl;

}      
        
// Load a word from a specified location in memory into the accumulator 
void CPU::OP_LOAD(int memory_address) {
    Accumulator = memory.Load(memory_address);

}

// Store a word from the accumulator into a specified location in memory
void CPU::OP_STORE(int memory_address) {
    memory.Store(memory_address, Accumulator);

}  
        
// Add a word from a specified location in memory to the accumulator
void CPU::OP_ADD(int memory_address) {
    Accumulator += memory.Load(memory_address);

}

// Subtract a word from a location in memory from the accumulator
void CPU::OP_SUB(int memory_address) {
    Accumulator -= memory.Load(memory_address);

}     

// Divide a word from a location into the value in the accumulator
void CPU::OP_DIV(int memory_address) {
    Accumulator /= memory.Load(memory_address);

}

// Multiply a word from a location into the value in the accumulator
void CPU::OP_MULT(int memory_address) {
    Accumulator *= memory.Load(memory_address);

}

// Branch to the specified location in memory
void CPU::OP_BRANCH(int memory_address) {
    InstructionPointer = memory_address;

}

// Branch to the specified location if the accumulator is negative
void CPU::OP_BRANCHNEG(int memory_address) {
    if (Accumulator <= 0) {
        OP_BRANCH(memory_address);

    }
}

// Branch to the specified location if the accumulator is zero 
void CPU::OP_BRANCHZERO(int memory_address) {
    if (Accumulator == 0) {
        OP_BRANCH(memory_address);

    }
}

// Throw a compiler error
void CPU::SYS_THROW_ERR() {
    cout << "Compiler error at " << InstructionPointer << endl;

}