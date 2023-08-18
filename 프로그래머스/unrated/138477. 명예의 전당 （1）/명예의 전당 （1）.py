def solution(k, score):
    answer = []
    result = []
    for i in range(len(score)):
        if i<=k-1:
            result.append(score[i])
            answer.append(min(result))
        else:
            if min(result)<score[i]:
                result[result.index(min(result))] = score[i]
                answer.append(min(result))
            else:
                answer.append(min(result))
    return answer