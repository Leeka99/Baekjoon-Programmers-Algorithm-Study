import sys
t = int(sys.stdin.readline().rstrip())
for _ in range(t):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    result = a*b

    while b > 0:
        a, b = b, a % b
    print(result//a)