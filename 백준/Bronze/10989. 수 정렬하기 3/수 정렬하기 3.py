import sys
num_list = [0] * 10001
num = int(sys.stdin.readline())

for _ in range(num):
    number = int(sys.stdin.readline())
    num_list[number] += 1

for i in range(10001):
    if num_list[i] != 0:
        for j in range(num_list[i]):
            print(i)