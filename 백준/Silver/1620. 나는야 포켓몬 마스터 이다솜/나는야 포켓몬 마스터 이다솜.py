import sys
N, M = map(int, sys.stdin.readline().rstrip().split())
dic = {}

for i in range(N):
    a = sys.stdin.readline().rstrip()
    dic[i+1] = a
    dic[a] = i+1

for _ in range(M):
    q = sys.stdin.readline().rstrip()
    if q.isdigit():
        print(dic[int(q)])
    else:
        print(dic[q])