def solution(food):
    answer = ''
    for i in range(1,len(food)):
        if food[i] % 2 != 0:
            n = i-1
        for j in range(food[i]//2):
            answer +=str(i)
    return answer+'0'+''.join(list(reversed(answer)))