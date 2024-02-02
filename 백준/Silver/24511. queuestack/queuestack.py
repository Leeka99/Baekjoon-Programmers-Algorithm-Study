import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
M = int(input())
C = list(map(int, input().split()))

queueStack = deque()

for i in range(N):
    if A[i] == 0:
        queueStack.appendleft(B[i])


for i in range(M):
    queueStack.append(C[i])
    print(queueStack.popleft(), end=" ")