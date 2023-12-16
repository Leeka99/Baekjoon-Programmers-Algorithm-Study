import sys
num = int(sys.stdin.readline())
coordination = list()
for _ in range(num):
    a, b = (map(int, sys.stdin.readline().split()))
    coordination.append([a, b])
coordination.sort()
for i in coordination:
    print(i[0], i[1])