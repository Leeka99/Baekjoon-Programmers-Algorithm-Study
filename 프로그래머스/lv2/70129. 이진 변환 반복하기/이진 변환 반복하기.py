def solution(s):
    answer = []
    result = []
    count_times = 0
    count_0 = 0
    while True:

        if len(s)==1:
            break
        for i in s:
            if i =='1':
                result.append(i)
            else:
                count_0 += 1
        count_times += 1
        s = bin(len(result))[2:]
        result.clear()
    answer.append(count_times)
    answer.append(count_0)
    return answer