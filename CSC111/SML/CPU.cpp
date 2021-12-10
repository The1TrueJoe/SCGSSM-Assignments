#include "CPU.h"
#include "RAM.h"

#include <iostream>
#include <array>
#include <string>

using namespace std;

// memory
RAM memory;

/**
 * @brief start the cpu
 * 
 * @param new_memory memory to load
 */

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

/**
 * @brief operation chooser
 * 
 * @param op_code operation code
 * @param memory_address memory address to use
 * @return int result
 */

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

/**
 * @brief Read a word from the keyboard into the specified memory location
 * 
 * @param memory_address memory address to use
 */

void CPU::OP_READ(int memory_address) {
    int in;
    cout << "Enter word" << endl;

    cin >> in;
    memory.Store(memory_address, in);

}

/**
 * @brief Write a word from a specified memory location onto the screen
 * 
 * @param memory_address memory address to display
 */

void CPU::OP_WRITE(int memory_address) {
    cout << memory.Load(memory_address) << endl;

}      

/**
 * @brief Load a word from a specified location in memory into the accumulator 
 * 
 * @param memory_address memory address to load
 */

void CPU::OP_LOAD(int memory_address) {
    Accumulator = memory.Load(memory_address);

}

/**
 * @brief Store a word from the accumulator into a specified location in memory
 * 
 * @param memory_address memory address to store
 */

void CPU::OP_STORE(int memory_address) {
    memory.Store(memory_address, Accumulator);

}  

/**
 * @brief Add a word from a specified location in memory to the accumulator
 * 
 * @param memory_address memory address to add into the accumulator
 */

void CPU::OP_ADD(int memory_address) {
    Accumulator += memory.Load(memory_address);

}

/**
 * @brief Subtract a word from a location in memory from the accumulator
 * 
 * @param memory_address memory address to subtract
 */

void CPU::OP_SUB(int memory_address) {
    Accumulator -= memory.Load(memory_address);

}     

/**
 * @brief Divide a word from a location into the value in the accumulator
 * 
 * @param memory_address memory address to divide to
 */

void CPU::OP_DIV(int memory_address) {
    Accumulator /= memory.Load(memory_address);

}

/**
 * @brief Multiply a word from a location into the value in the accumulator
 * 
 * @param memory_address memory address to multiply
 */

void CPU::OP_MULT(int memory_address) {
    Accumulator *= memory.Load(memory_address);

}

/**
 * @brief Branch to the specified location in memory
 * 
 * @param memory_address memory address to branch to
 */

void CPU::OP_BRANCH(int memory_address) {
    InstructionPointer = memory_address;

}

/**
 * @brief Branch to the specified location if the accumulator is negative
 * 
 * @param memory_address memory address to branch to
 */

void CPU::OP_BRANCHNEG(int memory_address) {
    if (Accumulator <= 0) {
        OP_BRANCH(memory_address);

    }
}

/**
 * @brief Branch to the specified location if the accumulator is zero 
 * 
 * @param memory_address memory address to branch to
 */

void CPU::OP_BRANCHZERO(int memory_address) {
    if (Accumulator == 0) {
        OP_BRANCH(memory_address);

    }
}

/**
 * @brief throw an error
 */

void CPU::SYS_THROW_ERR() {
    cout << "Compiler error at " << InstructionPointer << endl;

}