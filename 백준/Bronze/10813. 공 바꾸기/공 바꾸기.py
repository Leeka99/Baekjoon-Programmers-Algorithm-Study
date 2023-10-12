basket_num, time = map(int, input().split())
x = list()
for reset in range(1,basket_num+1):
    x.append(reset)
for solve in range(time):
    i, j = map(int, input().split())
    y = x[i-1]
    x[i-1] = x[j-1]
    x[j-1] = y
print(' '.join(map(str,x)))