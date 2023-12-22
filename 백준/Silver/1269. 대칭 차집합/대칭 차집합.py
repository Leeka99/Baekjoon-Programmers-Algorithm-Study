import sys
a, b = map(int, sys.stdin.readline().rstrip().split())
A = set(map(int, sys.stdin.readline().rstrip().split()))
B = set(map(int, sys.stdin.readline().rstrip().split()))
print(len(A-B) + len(B-A))