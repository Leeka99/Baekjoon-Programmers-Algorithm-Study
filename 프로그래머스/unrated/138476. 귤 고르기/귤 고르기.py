def solution(k, tangerine):
    diction = {}
    number = []
    for i in tangerine:
        if i in diction:
            diction[i] += 1
        else:
            diction[i] = 1

    for j in diction.values():
        number.append(j)
    number = sorted(number,reverse=True)

    for v in range(len(number)):
        if k-number[v] <= 0:
            return v+1
        else:
            k -= number[v]
            number