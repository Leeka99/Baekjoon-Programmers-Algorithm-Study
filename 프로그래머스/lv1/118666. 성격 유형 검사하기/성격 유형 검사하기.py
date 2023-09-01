def solution(survey, choices):
    answer = ''
    word_score = {'R':0, 'T':0, 'C':0, 'F':0, 'J':0, 'M':0, 'A':0, 'N':0}
    
    for s,c in zip(survey,choices):
        if c>4:
            word_score[s[1]] += c-4
        elif c<4:
            word_score[s[0]] += 4-c
    li = list(word_score.items())

    for i in range(0,8,2):
        if li[i][1]<li[i+1][1]:
            answer += li[i+1][0]
        else:
            answer += li[i][0]
    return answer