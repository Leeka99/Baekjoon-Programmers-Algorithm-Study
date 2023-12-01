number = int(input())
x_min = 10000
y_min = 10000

x_max = -10000
y_max = -10000

for _ in range(number):
    a, b = map(int, input().split())
    if a < x_min:
        x_min = a
    if b < y_min:
        y_min = b
    if x_max < a:
        x_max = a
    if y_max < b:
        y_max = b
answer = (x_max - x_min) * (y_max - y_min)
print(answer)