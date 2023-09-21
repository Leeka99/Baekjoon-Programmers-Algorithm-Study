def lcmm(a,b):
    for i in range(max(a,b),(a*b)+1):
        if i%a==0 and i%b==0:
            return i
def solution(arr):
    answer = 1
    for i in arr:
        answer = lcmm(answer,i)
    return answer