#include <array>
#include <string>

class RAM {
    public:
        // Constructor
        RAM();

        // Store into specific address
        void Store(int, int);

        // Load from specific address
        int Load(int);

        // Load from file into memmory
        void LoadFile(string);

        // Reset memory
        void SET(array<int, 100>);

    private:
        array<int, 100> memory;
        
};