import sys
N = int(sys.stdin.readline().rstrip())
n = sorted(map(int, sys.stdin.readline().rstrip().split()))
M = int(sys.stdin.readline().rstrip())
m = map(int, sys.stdin.readline().rstrip().split())

def binary_search (m, n, start, end):
    if start > end:
        return 0
    mid = (start + end) // 2
    if m == n[mid]: 
        return 1
    elif m < n[mid]: 
        return binary_search(i, n, start, mid-1) #찾을값이 mid보다 작다면 end값 수정
    else: 
        return binary_search(i, n, mid+1, end)   #찾을값이 mid보다 크다면 start값 수정

start, end = 0, len(n) - 1
for i in m:
    print(binary_search(i, n, start, end))