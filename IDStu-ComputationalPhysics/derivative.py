"""
Joseph Telaak
Computational Physics

Please write a program to compute the forward derivative, backward derivative, centered derivative and actual 
derivative of sin(x) evaluated at x = 0.50 using a small value of h and the errors in the three methods.  Which is 
the most accurate? 
"""

from numpy import sin, cos, fabs

## Manually created functions

# Original function
def f(x):
    return sin(x)

# Original function's first derivative
def fprime(x):
    return cos(x)

# Orginal functions's second derivative
def fdoubleprime(x):
    return -1 * sin(x)

## Calculations

# Calculates the forward derivative
# x: point on the function
# h: change in the point
def forward_derivative(x, h):
    return (f(x + h) - f(x)) / h

# Calculates the backwards derivative
# x: point on the function
# h: change in the point
def backward_derivative(x, h):
    return (f(x) - f(x - h)) / h

# Calculates the forward derivative
# Essentially the average between the forwards and backwards derivative
# x: point on the function
# h: change in the point
def centered_derivative(x, h):
    return (f(x + h) - f(x - h)) / 2 / h

# Calculates the second derivative
# x: point on the function
# h: change in the point
def second_derivative(x, h):
    return (f(x + h) - 2 * f(x) + f(x - h)) / h / h

# Interpolation
def interpolate(a, b):
    return ((f(b) - f(a)) / (b - a)) * (x - a) + f(a)

### Output

# Point on the function
x = .5
# Change 
h = .1

# Interpolated range
interp_lower = x - .05
interp_upper = x + .05

print(f"h = {h} x = {x}")
print("---------------------------------------------------------")
print(f"Actual Value: {fabs(f(x))}")
print(f"Actual Derivative: {fabs(fprime(x))}")
print(f"Actual 2nd Derivative: {fabs(fdoubleprime(x))}")
print("---------------------------------------------------------")
print(f"Forward Derivative Difference: {fabs(fprime(x) - forward_derivative(x, h))}")
print(f"Backwards Derivative Difference: {fabs(fprime(x) - backward_derivative(x, h))}")
print(f"Centered Derivative Difference: {fabs(fprime(x) - centered_derivative(x, h))}")
print("---------------------------------------------------------")
print(f"Interpolated Values (Lower: {interp_lower}, Upper: {interp_upper})")
print(f"Difference: {interpolate(interp_lower, interp_upper)}")