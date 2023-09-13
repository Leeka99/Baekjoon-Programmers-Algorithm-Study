a = input().upper()
word_list = list(set(a))
cnt =[]

for i in word_list:
    count = a.count(i)
    cnt.append(count)
if cnt.count(max(cnt)) >= 2:
    print('?')
else:
    print(word_list[cnt.index(max(cnt))])