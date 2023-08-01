def solution(num):
    count = 0
    while 1<num:
        if num%2 == 0:
            num = num//2
        else:
            num = (num*3)+1
        count +=1
        if 500<count:
            count =- 1
            break
    return count