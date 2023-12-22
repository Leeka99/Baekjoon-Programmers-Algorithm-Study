import sys
N, M = map(int, sys.stdin.readline().rstrip().split())
dhear = set(sys.stdin.readline().rstrip() for i in range(N))
dsee = set(sys.stdin.readline().rstrip() for i in range(M))

cnt = 0
answer = set()
for i in dhear:
    if i in dsee:
        cnt += 1
        answer.add(i)
print(cnt)
answer = sorted(answer)
for i in answer:
    print(i)