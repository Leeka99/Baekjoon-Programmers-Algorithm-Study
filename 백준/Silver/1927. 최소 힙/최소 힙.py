import sys
import heapq # heapq 모듈을 사용. 최소힙 기본.
N = int(sys.stdin.readline())
heap = list()

for _ in range(N):
    x = int(sys.stdin.readline())

    if x == 0:
        if len(heap):
            print(heapq.heappop(heap)) #heap에서 가장 작은 원소를 pop
        else:
            print(0)
    else:
        heapq.heappush(heap, x) #x를 heap에 추가