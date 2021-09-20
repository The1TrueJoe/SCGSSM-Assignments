#include <array>
#include <string>

class RAM {
    public:
        // Constructor
        RAM();

        // Constructor (Loads file)
        RAM(string);

        // Store into specific address
        void Store(int, int);

        // Load from specific address
        int Load(int);

        // Load from file into memmory
        array<int, 100> LoadFile(string);

    private:
        array<int, 100> memmory;
        
};