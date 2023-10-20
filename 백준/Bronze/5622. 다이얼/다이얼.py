word = input()
result = 0
alpa = ['ABC', 'DEF','GHI' , 'JKL', 'MNO', 'PQRS' ,'TUV' ,'WXYZ']
for i in range(len(word)):
    for j in alpa:
        if word[i] in j:
            result += alpa.index(j)+3
print(result)