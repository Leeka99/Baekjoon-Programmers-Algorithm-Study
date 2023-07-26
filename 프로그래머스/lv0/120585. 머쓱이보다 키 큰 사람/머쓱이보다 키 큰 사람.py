def solution(array, height):
    num = []
    for i in array:
        if i>height:
            num.append(i)
    answer = len(num)
    return answer