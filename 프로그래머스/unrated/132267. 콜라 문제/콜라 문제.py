def solution(a, b, n):
    answer = 0
    while a<=n:
        n,num1 = divmod(n,a)
        answer += (n*b)
        n = num1+(n*b)
    return answer