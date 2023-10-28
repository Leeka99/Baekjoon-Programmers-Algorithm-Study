count = int(input())
result = count
for i in range(count):
    word = input()
    for j in range(len(word)-1):
        if word[j] == word[j + 1]:
            pass
        elif word[j] in word[j+1:]:
            result -= 1
            break
print(result)