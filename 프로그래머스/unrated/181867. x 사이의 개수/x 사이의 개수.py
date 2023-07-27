def solution(myString):
    answer = []
    result = myString.split('x')
    answer.extend(len(i) for i in result)
    return answer