/*
 * Examine the following function which generates a “ dead code” error. What is a dead code error? Why does this code generate such an error?
 */

double absoluteValue( double x) {                    
if (x > 0)  return x;     
else if (x < 0) return -x;             
}

/* 
 * There will be an error because the code cannot handle a case where x = 0; 
 * Dead code usually refers to code that will never execute, such as placing code under return statements. 
 * In this case, it is referring to code that can’t handle all cases.
 */
