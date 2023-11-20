save = list()
n, k = map(int, input().split())
for i in range(1, n+1):
    if n % i == 0:
        save.append(i)
if len(save) < k:
    print(0)
elif len(save) >= k:
    print(save[k-1])