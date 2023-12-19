import sys
N = int(sys.stdin.readline())
cards = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
checks = list(map(int, sys.stdin.readline().split()))

dic = {}
for i in range(len(cards)):
    dic[cards[i]] = 0
for j in range(M):
    if checks[j] not in dic:
        print(0, end=' ')
    else:
        print(1, end=' ')