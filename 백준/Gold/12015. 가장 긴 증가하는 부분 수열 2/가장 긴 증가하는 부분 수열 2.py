import sys #LIS 알고리즘 문제. DP는 시간복잡도 O(N^2). 때문에 이분탐색 O(logN)이용. 최종 O(NlongN)
N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().rstrip().split()))

LIS = [A[0]]

def binary_search(i):
    start = 0
    end = len(LIS) - 1

    while start <= end:
        mid = (start + end) // 2

        if LIS[mid] == i:
            return mid
        elif LIS[mid] < i:
            start = mid + 1
        else:
            end = mid - 1
    return start

for i in A:
    if LIS[-1] < i:
        LIS.append(i) #i가 리스트 마지막 수 보다 크다면 i 추가
    else:
        idx = binary_search(i)
        LIS[idx] = i

print(len(LIS))