word_list = list()
length = list()
for _ in range(5):
    word = input()
    word_list.append(word)
    length.append(len(word))

answer = ""
for i in range(max(length)):
    for j in range(5):
        if i < length[j]:
            answer += word_list[j][i]
print(answer)