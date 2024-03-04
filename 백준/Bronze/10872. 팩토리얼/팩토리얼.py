N = int(input())
answer = 1
for i in range(N, 0, -1):
    answer *= i
print(answer)