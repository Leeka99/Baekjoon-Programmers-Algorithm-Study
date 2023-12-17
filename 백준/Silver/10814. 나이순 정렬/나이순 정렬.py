import sys
member_list = list()
num = int(sys.stdin.readline())
for _ in range(num):
    a, b = sys.stdin.readline().split()
    member_list.append([int(a), b])
member_list.sort(key = lambda x : x[0])
for i in member_list:
    print(i[0], i[1])