N,M = map(int,input().split())
list_a = list()
list_b = list()

for row in range(N):
    row = list(map(int, input().split()))
    list_a.append(row)

for row in range(N):
    row = list(map(int, input().split()))
    list_b.append(row)

for row in range(N):
    for col in range(M):
        print(list_a[row][col] + list_b[row][col], end = ' ')
    print()