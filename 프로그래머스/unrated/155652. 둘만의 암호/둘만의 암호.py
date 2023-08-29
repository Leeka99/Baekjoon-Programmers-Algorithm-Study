def solution(s, skip, index):
    answer = ""
    alpha = "abcdefghijklmnopqrstuvwxyz"

    for i in skip:
        if i in alpha:
            alpha = alpha.replace(i, "")

    for j in s:
        change = alpha[(alpha.index(j) + index) % len(alpha)]
        answer += change

    return answer