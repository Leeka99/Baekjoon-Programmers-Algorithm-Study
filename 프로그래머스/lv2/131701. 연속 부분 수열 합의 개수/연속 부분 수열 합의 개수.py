def solution(elements):
    result = set()
    element = elements*2

    for i in range(len(elements)):
        for j in range(len(elements)):
            result.add(sum(element[j:j+i+1]))
    return len(result)