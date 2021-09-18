/*
 * Created by Joseph Telaak
 *
 * CPU Based on SML
 */  

class CPU {
    public:
        // Accumulator
        int Accumulator;

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

};