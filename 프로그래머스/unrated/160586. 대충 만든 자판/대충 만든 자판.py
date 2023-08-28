def solution(keymap, targets):
    answer = {}
    for key in keymap:
        for i,value in enumerate(key):
            if value not in answer:
                answer[value] = i + 1
            else:
                answer[value] = min(answer[value],i+1)
    result = []
    for target in targets:
        clicked = 0
        for value in target:
            if value not in answer:
                clicked = -1
                break
            clicked += answer[value]
        result.append(clicked)
    return result