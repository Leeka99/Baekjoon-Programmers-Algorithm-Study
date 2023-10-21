result = [1,1,2,2,2,8]
piece = list(input().split())
for i in range(len(piece)):
    if piece[i] != result[i]:
        answer = int(result[i]) - int(piece[i])
        piece[i] = answer
print(' '.join(map(str,piece)))