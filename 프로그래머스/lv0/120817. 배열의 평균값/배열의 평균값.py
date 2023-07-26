def solution(numbers):
    sum = 0
    answer = 0
    for number in numbers:
        sum += number 
        answer = float(sum/len(numbers))
    return answer