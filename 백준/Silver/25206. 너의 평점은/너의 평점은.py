subject_score = {"A+":4.5, "A0":4.0, "B+":3.5, "B0":3.0, "C+":2.5, "C0":2.0, "D+":1.5, "D0":1.0, "F":0.0}
answer = 0
subject_num = 0
mul = 0
for _ in range(20):
    name,num,score = input().split()
    if score == "P":
        continue
    subject_num += float(num)
    mul += float(num) * subject_score[score]
answer = mul/subject_num
print(answer)