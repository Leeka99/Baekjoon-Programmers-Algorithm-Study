def solution(lottos, win_nums):
    answer = []
    count = 0
    num = 0
    goal = [6,6,5,4,3,2,1]
    for i in lottos:
        if i in win_nums:
            count += 1
        elif i == 0:
            num += 1
    answer.append(goal[count])
    answer.append(goal[count+num])
    answer = sorted(answer)
    return answer