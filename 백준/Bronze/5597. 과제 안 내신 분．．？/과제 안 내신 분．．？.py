result = list()
for _ in range(28):
    num = int(input())
    result.append(num)
for j in range(1,31):
    if j not in result:
        print(j)