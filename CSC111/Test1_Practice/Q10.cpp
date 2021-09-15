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
