N, M = map(int, input().split())
lecture = list(map(int, input().split()))

def binary_search(start, end): #이진탐색 적용
    while start <= end:
        mid = (start + end) // 2
        total = 0
        count = 1 #처음 한번 나눌 때 2개 블루레이 생기므로 +1
        for i in lecture:
            if total + i > mid: #합계가 mid 넘기면 블루레이 1개 증가
                count += 1
                total = 0
            total += i

        if count <= M:
            answer = mid
            end = mid - 1
        else:
            start = mid + 1
    return answer

start, end = max(lecture), sum(lecture)
print(binary_search(start, end))