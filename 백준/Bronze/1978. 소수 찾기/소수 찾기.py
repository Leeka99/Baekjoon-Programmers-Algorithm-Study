number = int(input())
count = 0
numbers = map(int, input().split())
for i in numbers:
    zero = 0
    if i == 1:
        continue
    for j in range(2, i):
        if i % j == 0:
            zero += 1
    if zero == 0:
        count += 1
print(count)