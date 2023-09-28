def solution(want, number, discount):
    answer = 0
    list_all_want = []

    for i in range(len(want)):
        for j in range(number[i]):
            list_all_want.append(want[i])
    list_all_want.sort()

    for i in range(len(discount) - 9):
        list_10 = discount[i: i+10]
        list_10.sort()
        if list_all_want == list_10:
            answer += 1
            
    return answer