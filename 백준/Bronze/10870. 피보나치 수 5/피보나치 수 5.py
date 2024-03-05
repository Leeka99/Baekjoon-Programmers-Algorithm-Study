n = int(input())
x1, x2 = 0, 1
answer = 0
if n == 0:
    print(0)
elif n == 1:
    print(1)
else:
    for i in range(2, n+1):
        answer = x1 + x2
        x1 = x2
        x2 = answer
    print(answer)