N = int(input())
A = list(map(int, input().split()))
A.sort()

def binary_search(goal, start, end):
    while start < end:
        if A[start] + A[end] == goal:
            if start == i:
                start += 1
            elif end == i:
                end -= 1
            else:
                return 1
        elif A[start] + A[end] > goal:
            end -= 1
        elif A[start] + A[end] < goal:
            start += 1

cnt = 0
for i in range(N):
    goal = A[i]
    start = 0
    end = len(A) - 1
    if binary_search(goal, start, end) == 1:
        cnt += 1

print(cnt)