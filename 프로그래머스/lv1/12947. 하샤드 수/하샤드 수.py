def solution(x):
    if x % (sum(map(int,str(x)))) ==0:
        answer = True
    else:
        answer = False
    return answer