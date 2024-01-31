import sys
from collections import deque
N = int(sys.stdin.readline())
dq = deque()

for _ in range(N):
    command = list(map(int, sys.stdin.readline().split()))

    if command[0] == 1:
        dq.appendleft(command[1])

    elif command[0] == 2:
        dq.append(command[1])

    elif command[0] == 3:
        if len(dq) != 0:
            print(dq.popleft())
        else:
            print(-1)

    elif command[0] == 4:
        if len(dq) != 0:
            print(dq.pop())
        else:
            print(-1)

    elif command[0] == 5:
        print(len(dq))

    elif command[0] == 6:
        if len(dq) != 0:
            print(0)
        else:
            print(1)

    elif command[0] == 7:
        if len(dq) != 0:
            print(dq[0])
        else:
            print(-1)

    elif command[0] == 8:
        if len(dq) != 0:
            print(dq[-1])
        else:
            print(-1)