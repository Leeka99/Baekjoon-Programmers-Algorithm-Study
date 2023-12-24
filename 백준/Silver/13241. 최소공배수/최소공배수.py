# 최대공약수 식 : x,y = y, x % y
# 최소공배수 식 : (x*y // 최대공약수)
# 수학 정수론에 의하면 두 수 A, B 의 곱은 최대공약수 G와 최소공배수 L의 곱과 같다.
# 그리고 유클리드 호제법을 사용하면 빠르게 최대공약수를 구할 수 있다.
# 유클리드 호제법을 사용해 최대공약수를 구하고, 두 수의 곱에 구한 최대공약수를 나누면 해당 문제의 정답인 최소공배수를 출력 할 수 있다.
import sys
a, b = map(int, sys.stdin.readline().rstrip().split())
result = a*b

while b > 0:
    a, b = b, a % b
print(result//a)