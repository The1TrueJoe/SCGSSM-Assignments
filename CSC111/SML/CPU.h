/*
 * Created by Joseph Telaak
 *
 * CPU Based on SML
 */  

#include "RAM.h"

class CPU {
    public:
        // Accumulator stores a word that cpu is working on
        int Accumulator;

        // Instruction Pointer 
        int InstructionPointer;

        // Starts
        void Start();

        // Operate
        int OP(int op_code, int memmory_adress);

        // Memmory
        RAM memmory;

        // OPCODES
        static const int READ       = 10; // Read a word from the keyboard into the specified memory location
        static const int WRITE      = 11; // Write a word from a specified memory location onto the screen
        static const int LOAD       = 20; // Load a word from a specified location in memory into the accumulator 
        static const int STORE      = 21; // Store a word from the accumulator into a specified location in memory
        static const int ADD        = 30; // Add a word from a specified location in memory to the accumulator
        static const int SUB        = 31; // Subtract a word from a location in memory from the accumulator
        static const int DIV        = 32; // Divide a word from a location into the value in the accumulator
        static const int MULT       = 33; // Multiply a word from a location into the value in the accumulator
        static const int BRANCH     = 40; // Branch to the specified location in memory
        static const int BRANCHNEG  = 41; // Branch to the specified location if the accumulator is negative
        static const int BRANCHZERO = 42; // Branch to the specified location if the accumulator is zero 
        static const int HALT       = 43; // Halt

    private:

        // Operations
        int OP_READ(int);       // Read a word from the keyboard into the specified memory location
        int OP_WRITE(int);      // Write a word from a specified memory location onto the screen
        int OP_LOAD(int);       // Load a word from a specified location in memory into the accumulator 
        int OP_STORE(int);      // Store a word from the accumulator into a specified location in memory
        int OP_ADD(int);        // Add a word from a specified location in memory to the accumulator
        int OP_SUB(int);        // Subtract a word from a location in memory from the accumulator
        int OP_DIV(int);        // Divide a word from a location into the value in the accumulator
        int OP_MULT(int);       // Multiply a word from a location into the value in the accumulator
        int OP_BRANCH(int);     // Branch to the specified location in memory
        int OP_BRANCHNEG(int);  // Branch to the specified location if the accumulator is negative
        int OP_BRANCHZERO(int); // Branch to the specified location if the accumulator is zero 
        int OP_HALT(int);       // Halt

};