def solution(s1, s2):
    answer = sum(s2.count(i) for i in s1)
    return answer