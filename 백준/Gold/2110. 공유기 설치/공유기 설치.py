import sys
N, C = map(int, sys.stdin.readline().rstrip().split())
length = list()

for _ in range(N):
    length.append(int(sys.stdin.readline().rstrip()))
length = sorted(length)

def binary_search(length, start, end):
    while start <= end:
        mid = (start + end) // 2
        current = length[0]
        count = 1

        for i in range(1, len(length)): #mid값 기준으로 거리 큰 것을 고르기
            if length[i] >= current + mid:
                count += 1
                current = length[i]

        if count >= C: #count값에 따라 범위 재설정
            global answer #전역변수 설정
            start = mid + 1
            answer = mid
        else:
            end = mid - 1


start = 1
end = length[-1] - length[0]
answer = 0

binary_search(length, start, end)
print(answer)