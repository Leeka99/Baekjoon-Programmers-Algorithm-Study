def solution(a, b):
    x = min(a,b)
    y = max(a,b)
    answer = 0
    for i in range(x,y+1):
        answer +=i
    return answer