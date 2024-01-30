import sys
from collections import deque
N, k = map(int, sys.stdin.readline().split())
queue = deque(range(1, N+1))

pus = list()
while len(queue) != 0:
    for _ in range(k-1):
        queue.append(queue.popleft())
    pus.append(str(queue.popleft()))

print('<'+', '.join(pus)+'>')