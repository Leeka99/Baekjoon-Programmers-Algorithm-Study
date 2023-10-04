n = int(input())

test = list(map(int,input().split()))
high = max(test)
for i in range(n):
    test[i] = test[i]/high*100
result= sum(test)/n
print(result)