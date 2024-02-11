import sys
K, N = map(int, sys.stdin.readline().rstrip().split())
k = sorted(int(sys.stdin.readline().rstrip()) for _ in range(K))

def binary_search(start, end):
    while start <= end:
        mid = (start + end) // 2
        lines = 0
        for i in k:
            lines += i // mid #mid길이로 만들 수 있는 랜선 수 찾는다.
        if lines >= N:
            start = mid + 1 #필요한 랜선길이보다 많다면 start값 조정. 랜선 길이를 길게 잡는다.
        else:
            end = mid - 1 #필요한 랜선길이보다 적다면 end값 조정. 랜선 길이를 짧게 잡는다.
    return end

start, end = 1, k[-1] #시작길이 1, 최대길이 k[-1]로 시작
print(binary_search(start, end))