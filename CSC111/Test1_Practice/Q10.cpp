/*
 * The isPrime function is passed a positive integer and returns true if the integer 
 * is a prime number or false if it is not a prime number.  
 * Implement the code for this function using  only one return statement.
 */


bool isPrime (int num) {
    bool prime = true;
    
    for (int i = 2; i < num / 2; i++) {
        if (num % i == 0) {
            prime = false;
            break;
        }
    }
    
    return prime;
}
