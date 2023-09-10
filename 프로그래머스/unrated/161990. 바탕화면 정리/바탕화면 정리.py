def solution(wallpaper):
    answer_a = []
    answer_b = []
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == '#':
                answer_a.append(i)
                answer_b.append(j)
    return [min(answer_a),min(answer_b),max(answer_a)+1,max(answer_b)+1]