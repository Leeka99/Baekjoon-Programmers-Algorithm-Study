import sys
X, Y = map(int, sys.stdin.readline().rstrip().split())
z = (Y*100)//X

def binary_search(X, Y, start, end, answer, z):
    if z >= 99: #승률 99일때 승률 변하지 않는다.
        return -1
    while start <= end:
        mid = (start + end) // 2
        if (100*(Y+mid)) // (X+mid) > z: #승률이 올라가면
            answer = mid #줄인 게임횟수 저장
            end = mid - 1 #게임 횟수 범위 줄이기
        else:
            start = mid + 1
    return answer
start ,end, answer = 0, X, X #승률 98일때 X번만큼 추가하면 99로 변하기 때문에 answer에 X값을 초기값으로 설정
print(binary_search(X, Y, start, end, answer, z))