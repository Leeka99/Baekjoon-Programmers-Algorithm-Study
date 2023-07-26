def solution(money):
    ice = money//5500
    money -= ice*5500
    answer = [ice,money]
    return answer