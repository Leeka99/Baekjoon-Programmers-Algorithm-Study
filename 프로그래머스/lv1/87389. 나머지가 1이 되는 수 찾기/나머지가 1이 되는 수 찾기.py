def solution(n):
    for i in range(1,n+1):
        answer = n%i
        if answer == 1:
            return i