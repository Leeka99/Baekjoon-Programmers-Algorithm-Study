cnt = 0
sum_result = 0
num_set = set()
for _ in range(3):
    a = int(input())
    num_set.add(a)
    if a == 60:
        cnt += 1
    sum_result += a
if cnt == 3:
    print('Equilateral')
elif sum_result == 180 and  len(num_set) == 2:
    print('Isosceles')
elif sum_result == 180 and len(num_set) == 3:
    print('Scalene')
elif sum_result != 180:
    print('Error')