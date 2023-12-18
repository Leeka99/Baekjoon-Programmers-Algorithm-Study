import sys
num = int(sys.stdin.readline())
number_list = list(map(int, sys.stdin.readline().split()))
arr = sorted(set(number_list))
dic = {arr[i]:i for i in range(len(arr))}

for i in number_list:
    print(dic[i], end=' ')