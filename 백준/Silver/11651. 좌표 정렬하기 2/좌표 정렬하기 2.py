import sys
coordination = list()
num = int(sys.stdin.readline())
for _ in range(num):
    a, b = map(int, sys.stdin.readline().split())
    coordination.append([a, b])
coordination.sort(key = lambda x: (x[1], x[0]))
for i in coordination:
    print(i[0], i[1])