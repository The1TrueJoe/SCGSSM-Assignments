# 4.2: Quadratic Equations

'''
a) Write a program that takes as input the three numbers, a, b, and c, and prints out
the two solutions using the standard formula
'''


def normal_quadratic(a, b, c):
    x1 = (-b + (b ** 2 - 4 * a * c) ** .5) / 2 / a
    x2 = (-b - (b ** 2 - 4 * a * c) ** .5) / 2 / a

    return x1, x2


'''
b) There is another way to write the solutions to a quadratic equation. Multiplying
top and bottom of the solution above by -b^2 +- sqrt(b2 - 4ac), show that the solutions
can also be written as 
'''


def flipped_quadratic(a, b, c):
    x1 = 2 * c / (-b + (b ** 2 - 4 * a * c) ** .5)
    x2 = 2 * c / (-b - (b ** 2 - 4 * a * c) ** .5)

    return x1, x2


'''
c) Using what you have learned, write a new program that calculates both roots of a quadratic equation accurately 
in all cases. 
Avoids rounding error from subtraction (-b - x) is the same as -(b + x), so subtraction is avoided by 
using both addition cases 
'''

def proper_quadratic(a, b, c):
    x1 = normal_quadratic(a, b, c)[1]
    x2 = flipped_quadratic(a, b, c)[1]
    
    return x1, x2

# Output

print(normal_quadratic(1, -10e5, 1))
print(flipped_quadratic(1, -10e5, 1))
print(proper_quadratic(.001, 1000, .001))