def solution(s):
    answer = []
    result = ''
    for i in range(len(s)):
        if s[i] in result:
            answer.append(i - result.find(s[i]))
            result = result.replace(s[i],' ')
        else:
            answer.append(-1)
        result += s[i]
    return answer