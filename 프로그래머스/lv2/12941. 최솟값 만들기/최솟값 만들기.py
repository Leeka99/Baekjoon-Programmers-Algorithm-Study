def solution(A,B):
    result = []
    A.sort()
    B.sort()
    for i in range(len(A)):
        result.append(A[i] * B[len(B)-i-1])
    return sum(result)