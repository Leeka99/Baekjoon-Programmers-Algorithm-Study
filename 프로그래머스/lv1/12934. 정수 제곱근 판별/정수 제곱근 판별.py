def solution(n):
    answer = n**(1/2)
    if (answer % int(answer)) == 0:
        answer = (int(answer)+1)**2
    else:
        answer = -1
    return answer