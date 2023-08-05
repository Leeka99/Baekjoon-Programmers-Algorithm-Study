def solution(a, b):
    result = 0
    answer = {key:value for key,value in zip(a,b)}
    for i in range(len(a)):
        result += a[i]*b[i]
        print("11::",result)
    return result