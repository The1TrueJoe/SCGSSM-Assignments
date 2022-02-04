from numpy import arange, sin, sqrt, power, fabs, sum


def f(x):
    return power(sin(sqrt(100 * x)), 2)


def trapezoidal_integral(a, b, n):  # from 5.2
    h = (b - a) / n
    x = arange(1, n)
    return h * ((f(a) / 2) + (f(b) / 2) + sum(f(a + x * h)))


def adaptive_trapezoidal(a, b, n, desired_error):
    last = trapezoidal_integral(a, b, n)
    err = 9e4
    print(desired_error)
    while err > desired_error:
        print(f'slices: {n}')
        print(f'estimate: {last}')
        print(f'error: {err}')
        n *= 2
        h = (b - a) / n
        k = arange(1, n - 1, 2)
        new = (last / 2) + h * sum(f(a + k * h))
        err = fabs((new - last)) / 3
        last = new
    return last


def romberg_integration(a, b, desired_error):
    r = [[trapezoidal_integral(a, b, 1)], [trapezoidal_integral(a, b, 2)]]
    i = 1
    j = 0
    n = 3
    err = 9e4
    
    while err > desired_error:
        while i > j:
            r[i].append(r[i][j] + (1 / (power(4, j + 1) - 1) * (r[i][j] - r[i - 1][j])))

            err = (r[i][j] - r[i - 1][j]) / (power(4, j + 1) - 1)
            if err < desired_error:
                print(i, j, err)
                for i2 in range(len(r)):
                    print([term for term in r[i2]])
                return r[i][j]
            j += 1

        r.append([trapezoidal_integral(a, b, n)])
        i += 1
        n += 1
        j = 0
    return r[i][j]


adaptive_trapezoidal(0, 1, 1, 1e-6)
romberg_integration(0, 1, 1e-6)