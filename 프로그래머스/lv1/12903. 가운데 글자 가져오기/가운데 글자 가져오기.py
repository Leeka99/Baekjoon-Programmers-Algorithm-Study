def solution(s):
    result = []
    for i in s:
        result.append(i)
    if len(s) %2==0:
        answer = result[len(s)//2-1: len(s)//2+1]
        return "".join(answer)
    else:
        answer = result[(len(s)//2)]
    return answer