white_paper = [[0 for _ in range(101)] for _ in range(101)]
N = int(input())

for _ in range(N):
    x, y =  list(map(int, input().split()))

    for x_idx in range(x,x+10):
        for y_idx in range(y,y+10):
            white_paper[x_idx][y_idx] = 1

answer = 0
for array_row in white_paper:
	answer += array_row.count(1)

print(answer)