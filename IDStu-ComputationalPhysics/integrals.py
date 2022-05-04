from math import fabs
from numpy import arange, log
import matplotlib.pyplot as plt
import numpy as np

# Original Function
def f(x):
    return x ** 4 - 2 * x + 1

# Trapezoidal integral
def trapezoidal_integral(a, b, n):
    h = (b - a) / n
    return h * ((f(a) / 2) + (f(b) / 2) + sum(f(a + arange(1, n) * h)))

# Simpson integral
def simpson_integral(a, b, n):
    h = (b - a) / n
    return h * (f(a) + f(b) + 4 * sum(f(a + arange(1, n, 2) * h)) + 2 * sum(f(a + arange(2, n, 2) * h))) / 3

