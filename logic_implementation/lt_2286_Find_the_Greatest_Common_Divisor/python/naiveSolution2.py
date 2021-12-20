import sys

a = int(sys.argv[1])
b = int(sys.argv[2])

setx = set()
sety = set()

for i in range(2, a+1):
    if a % i == 0:
        setx.add(i)
for i in range(2, b+1):
    if b % i == 0:
        sety.add(i)

result = setx & sety
print(max(result))