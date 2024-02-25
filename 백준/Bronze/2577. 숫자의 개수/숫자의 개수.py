mul = 1
for _ in range(3):
    mul *= int(input())
result = [0] * 10

for i in str(mul):
    result[int(i)] += 1

for count in result:
    print(count)