m = int(input())
n = int(input())
sosu_list = list()
number = m

while(number <= n):
    for i in range(2, number+1):
        if i == number:
            sosu_list.append(number)
        if number % i == 0:
            break
    number += 1
if len(sosu_list) == 0:
    print(-1)
elif len(sosu_list) != 0:
    print(sum(sosu_list))
    print(min(sosu_list))