def solution(players, callings):
    scores = dict()
    for score,name in enumerate(players):
        scores[name] = score

    for call in callings:
        idx = scores[call]
        scores[call] -= 1
        scores[players[idx-1]] += 1
        players[idx-1],players[idx] = players[idx],players[idx-1]
    return players