students, number = map(int, input().split())
student_scores = list(map(int, input().split()))
student_scores.sort()
print(student_scores[-number])