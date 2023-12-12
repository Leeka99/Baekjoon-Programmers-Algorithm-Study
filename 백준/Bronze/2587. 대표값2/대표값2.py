middle_num = list(int(input()) for _ in range(5))
middle_num = sorted(middle_num)
print(sum(middle_num)//5)
print(middle_num[2])