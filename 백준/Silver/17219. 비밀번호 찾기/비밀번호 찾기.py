import sys
N, M = map(int, sys.stdin.readline().split())
n = dict()
for _ in range(N):
    d, p = sys.stdin.readline().split()
    n[d] = p

for _ in range(M):
    m = sys.stdin.readline().rstrip()
    print(n[m])