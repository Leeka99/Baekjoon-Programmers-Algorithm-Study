import sys
num_list = list(int(sys.stdin.readline()) for _ in range(int(sys.stdin.readline())))
num_list.sort()
for i in num_list:
    print(i)