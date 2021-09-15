#include <iostream>
#include <string>

using namespace std;

int main() {  
    string saying = "happy  ";        
    
    //  to add “ day” to the saying
    saying += "day";
    
    // to store the number of letters in the saying into the num_letters variable  
    int num_letters  =  sizeof(saying);
    std::cout << "saying has size of " << num_letters << std::endl;

    //to display the last letter in the saying    
    char last = saying[num_letters - 1];
    std::cout << "last letter " << last << std::endl;
    
    //Change the saying to be uppercase  
    for(int i = 0; i < saying.length(); i++) {   
        if(saying[i] >= 'a' && saying[i] <= 'z'){  
            saying[i] = ((char)(saying[i] - 'a' + 'A'));
        }
    }
    
    std::cout << saying << "\n"; 
    
    return 0;
}
