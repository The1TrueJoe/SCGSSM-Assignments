from math import fabs

import matplotlib.pyplot as plt
import numpy as np
from numpy import arange, log

t_err = []
s_err = []
stepsize = []


def f(x):
    return x ** 4 - 2 * x + 1


def trapezoidal_integral(a, b, n):
    h = (b - a) / n
    x = arange(1, n)
    return h * ((f(a) / 2) + (f(b) / 2) + sum(f(a + x * h)))


def simpson_integral(a, b, n):
    h = (b - a) / n
    x1 = arange(1, n, 2)
    x2 = arange(2, n, 2)
    return h * (f(a) + f(b) + 4 * sum(f(a + x1 * h)) + 2 * sum(f(a + x2 * h))) / 3


def check_estimate(estimate):
    print(f'Your estimate was: {estimate}')
    print(f'Real value: 4.4')
    print(f'Fractional Error: {100 * fabs((4.4 - estimate) / 4.4)}%')
    return fabs(4.4 - estimate)


def test_algorithms(a, b, n):
    t = trapezoidal_integral(a, b, n)
    t_err.append(check_estimate(t))
    s = simpson_integral(a, b, n)
    s_err.append(check_estimate(s))
    stepsize.append(n)


for n in range(1, 1000, 10):
    test_algorithms(0, 2, n)

stepsize = np.array(stepsize)

t_err = np.array(t_err)
s_err = np.array(s_err)

fig, ax = plt.subplots()
ax.plot(log(stepsize), log(t_err), label="Trapezoidal Approximation")
ax.plot(log(stepsize), log(s_err), label="Simpson's Approximation")
ax.legend()

plt.show()

t_slope, _ = np.polyfit(log(stepsize), log(t_err), 1)
s_slope, _ = np.polyfit(log(stepsize), log(s_err), 1)

print(t_slope)
print(s_slope)