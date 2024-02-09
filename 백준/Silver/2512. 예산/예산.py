import sys
N = int(sys.stdin.readline().rstrip())
n = list(map(int, sys.stdin.readline().rstrip().split()))
budget = int(sys.stdin.readline().rstrip())

def binary_search(start, end):
    global answer # 전역변수 설정
    while start <= end:
        mid = (start + end) // 2
        total = sum(min(mid, i) for i in n)

        if total <= budget: #예산보다 작다면 시작값 + 1
            start = mid + 1
            answer = mid
        else: # 예산보다 크다면 최고값 - 1 
            end = mid - 1

start, end = 0, max(n)
answer = 0
binary_search(start, end)
print(answer)