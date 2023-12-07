n = int(input())
for i in range(n):
    sum_number = i + sum(map(int, str(i)))
    if sum_number == n:
        print(i)
        break
else:
    print(0)