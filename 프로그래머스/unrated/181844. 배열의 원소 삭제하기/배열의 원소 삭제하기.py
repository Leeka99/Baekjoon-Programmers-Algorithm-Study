def solution(arr, delete_list):
    answer = []
    s1 = []
    for i in arr:
        for j in delete_list:
            if i == j:
                s1.append(i)
                arr = [x for x in arr if x not in s1 ]
    return arr