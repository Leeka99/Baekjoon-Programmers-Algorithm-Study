basket, line = map(int, input().split())
basket_list = list()

for num in range(basket+1):
    basket_list.append(num)
for _ in range(line):
    stat, end = map(int, input().split())
    tmp = basket_list[end:stat-1:-1]
    basket_list[stat:end+1] = tmp
basket_list.remove(0)
print(' '.join(map(str,basket_list)))