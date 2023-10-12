x = [int(input()) % 42 for i in range(10)]
x = list(set(x))
print(len(x))