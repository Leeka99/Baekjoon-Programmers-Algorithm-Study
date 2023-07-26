def solution(n):
    num =[]
    for i in range(1,n+1):
        if n%i==0:
            num.append(i)
    answer = len(num)
    return answer