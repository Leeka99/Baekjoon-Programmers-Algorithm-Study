num, x = map(int, input().split())
n = list(map(int, input().split()))
for i in n:
    if i<x:
        print(i, end=' ')