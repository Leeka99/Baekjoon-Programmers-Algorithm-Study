basket, line = map(int,input().split())
x = [0] * basket

for i in range(line):
    line_start,line_end,number = map(int,input().split())
    x[line_start-1:line_end] = [number]*(line_end-line_start+1)
print(' '.join(map(str,x)))
