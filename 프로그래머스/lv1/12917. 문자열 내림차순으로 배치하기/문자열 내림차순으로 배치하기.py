def solution(s):
    result = []
    for i in s:
        result.append(i)
    result.sort(reverse =True)
    answer = "".join(result)
    return answer