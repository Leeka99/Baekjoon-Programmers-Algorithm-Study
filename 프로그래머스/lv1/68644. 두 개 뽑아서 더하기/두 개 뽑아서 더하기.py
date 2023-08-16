def solution(numbers):
    answer = []
    le = len(numbers)
    for i in range(le):
        for j in range(i+1,le):
            answer.append(numbers[i]+numbers[j])
    answer = list(set(answer))
    return sorted(answer)