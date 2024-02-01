#deque.rotate 사용하기. # 인덱스와 종이 값을 튜플로 묶기 위해 enumerate 사용.
import sys
from collections import deque

N = int(sys.stdin.readline())
dq = deque(enumerate(map(int, sys.stdin.readline().split())))

result = list()

while dq:
    index, paper = dq.popleft()
    result.append(index + 1)

    if paper > 0:
        dq.rotate(-(paper - 1))
    else:
        dq.rotate(-paper)
print(' '.join(map(str, result)))