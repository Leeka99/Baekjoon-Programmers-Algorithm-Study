def solution(n):
    zero, first = 0, 1
    for i in range(n):
        zero, first = first, zero + first
    return zero % 1234567