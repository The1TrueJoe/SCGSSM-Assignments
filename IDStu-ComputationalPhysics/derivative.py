from numpy import sin, cos, fabs

# Function

def f(x):
    return sin(x)


"""Please write a program to compute the forward derivative, backward derivative, centered derivative and actual 
derivative of sin(x) evaluated at x = 0.50 using a small value of h and the errors in the three methods.  Which is 
the most accurate? """

# Math

def forward_difference(x, h):
    return (f(x + h) - f(x)) / h


def backward_difference(x, h):
    return (f(x) - f(x - h)) / h


def centered_difference(x, h):
    return (f(x + h) - f(x - h)) / 2 / h


def actual_derivative(x):
    return cos(x)


def actual_second_derivative(x):
    return -1 * sin(x)


def second_derivative(x, h):
    return (f(x + h) - 2 * f(x) + f(x - h)) / h / h


def interpolate(a, b):
    return ((f(b) - f(a)) / (b - a)) * (x - a) + f(a)

# Output

x = .5
h = .1

abs = actual_derivative(x)

for func in [forward_difference(x, h), backward_difference(x, h), centered_difference(x, h)]:
    print(fabs(abs - func))

print(fabs(actual_second_derivative(x) - second_derivative(x, h)))
print(fabs(interpolate(x - .05, x + .05) - sin(x)))