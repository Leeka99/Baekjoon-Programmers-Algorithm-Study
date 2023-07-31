def solution(n):
    result = []
    answer = 0
    for i in range(1,n+1):
        x,y = divmod(n,i)
        if y ==0:
            answer += x
    return answer