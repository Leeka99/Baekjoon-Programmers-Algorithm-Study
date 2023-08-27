def solution(s):
    answer = 0
    n1 = ''
    now_count = 0
    new_count = 0
    for i in s:
        if n1.isspace() or now_count == new_count:
            answer += 1
            n1.replace(n1,'')
            n1 = i
            new_count = 0
            now_count = 0

        if i in n1:
            now_count += 1
        else:
            new_count += 1
    return answer