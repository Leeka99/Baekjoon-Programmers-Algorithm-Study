import sys
from collections import deque
N = int(sys.stdin.readline())
queue = deque()
for _ in range(N):
    command = sys.stdin.readline().split()

    #push
    if (command[0] == "push"):
        queue.insert(0, command[1])

    #pop
    elif (command[0] == "pop"):
        if (len(queue) != 0):
            print(queue.pop())
        else:
            print(-1)

    #size
    elif (command[0] == "size"):
        print(len(queue))

    #empty
    elif (command[0] == "empty"):
        if (len(queue) != 0):
            print(0)
        else:
            print(1)

    #front
    elif (command[0] == "front"):
        if(len(queue) != 0):
            print(queue[-1])
        else:
            print(-1)

    #back
    elif (command[0] == "back"):
        if(len(queue) != 0):
            print(queue[0])
        else:
            print(-1)