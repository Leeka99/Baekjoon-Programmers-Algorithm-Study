import sys
N, M = map(int, sys.stdin.readline().split())

S = {}
for _ in range(N):
    s = sys.stdin.readline()
    S[s] = True

cnt = 0
for _ in range(M):
    check_words = sys.stdin.readline()
    if check_words in S:
       cnt += 1
print(cnt)