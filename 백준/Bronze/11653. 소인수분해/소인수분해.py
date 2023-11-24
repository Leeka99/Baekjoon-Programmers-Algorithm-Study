number = int(input())

if number == 1:
    print()

for i in range(2, number + 1):
    if number % i == 0:
        while number % i == 0:
            print(i)
            number /= i
