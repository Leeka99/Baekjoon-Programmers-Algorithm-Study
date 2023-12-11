num = list()
number = int(input())
for _ in range(number):
    num.append(int(input()))
num = sorted(num)
for i in range(len(num)):
    print(num[i])