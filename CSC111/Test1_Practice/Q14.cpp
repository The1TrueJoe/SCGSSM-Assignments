/* 
 * Write the code to declare a struct to represent the time in hours,  
 * minutes, and seconds (all whole numbers).  
 * Write a function update() which is passed the number of hours, minutes, and seconds which are  
 * added to the current time.  
 * In main(), set the current time to 12:45:30 and call update to add 
 * 1 hour, 20 minutes, and 15 seconds to the time.Display the updated time in main().
 */

#include <iostream>

using namespace std;

struct Time {
    int hours;
    int minutes;
    int seconds;
};

void update(Time time, int hours, int minutes, int seconds) {
    if (time.seconds + seconds >= 60) {
        minutes += 1;
        time.seconds = (time.seconds + seconds) - 60;
        
    } else {
        time.seconds += seconds;
        
    }
    
    if (time.minutes + minutes >= 60) {
        hours += 1;
        time.minutes = (time.minutes + seconds) - 60;
        
    } else {
        time.minutes += minutes;
        
    }
    
    if (time.hours + hours > 12) {
        time.hours = (time.hours + hours) - 12;
        
    } else {
        time.hours += hours;
        
    }
    
}

int main()
{
    
    Time time;
    time.hours = 12;
    time.minutes = 45;
    time.seconds = 30;
    
    cout << "Hour: " << time.hours << endl;
    cout << "Min: " << time.minutes << endl;
    cout << "Sec: " << time.seconds << endl;
    
    update(time, 1, 20, 15);
    cout << "Update" << endl;
    
    cout << "Hour: " << time.hours << endl;
    cout << "Min: " << time.minutes << endl;
    cout << "Sec: " << time.seconds << endl;
    
    
    
}
