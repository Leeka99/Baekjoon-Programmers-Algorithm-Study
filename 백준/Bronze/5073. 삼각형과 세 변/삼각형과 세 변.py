while(True):
    result = set()
    a, b, c = map(int, input().split())
    result.add(a)
    result.add(b)
    result.add(c)
    if (a == 0 and b == 0 and c == 0):
        break
    if (max(a, b, c) < (a+b+c)-max(a, b, c)):
        if (len(result) == 3):
            print("Scalene")
            result.clear()
        elif (len(result) == 2):
            print("Isosceles")
            result.clear()
        elif (len(result) == 1):
            print("Equilateral")
            result.clear()
    elif (max(a, b, c) >= (a+b+c)-max(a, b, c)):
        print("Invalid")