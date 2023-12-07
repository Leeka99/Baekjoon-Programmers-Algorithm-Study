giving_number , max_num = map(int, input().split())
number = list(map(int, input().split()))

big_number = 0
for i in range(giving_number):
    for j in range(i + 1, giving_number):
        for k in range(j + 1, giving_number):
            sum_number = number[i]+number[j]+number[k]
            if sum_number <= max_num:
                big_number = max(big_number,sum_number)
print(big_number)