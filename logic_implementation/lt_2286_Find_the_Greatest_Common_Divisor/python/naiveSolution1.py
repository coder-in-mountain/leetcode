import sys

a = int(sys.argv[1])
b = int(sys.argv[2])

res = 1
minVal = min(a, b)
for i in range(2, minVal + 1):
    if a % i == 0 and b % i == 0:
        a /= i
        b /= i
        res *= i
print(res)
