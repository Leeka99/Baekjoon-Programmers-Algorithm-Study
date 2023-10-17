result = list()
num = int(input())
for _ in range(num):
    first_num, word1 = input().split()
    for i in range(len(word1)):
        result.append(word1[i]*int(first_num))
    print(''.join(result))
    result.clear()