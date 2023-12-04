a, b, c = map(int, input().split())
big_num = max(a, b, c)
two_side = (a + b + c)- max(a, b, c)
if (big_num < two_side):
    print(a + b + c)
else:
    d = big_num
    d = two_side - 1
    print(two_side + d)