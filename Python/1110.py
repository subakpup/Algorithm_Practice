import sys
input = sys.stdin.readline
n = int(input())
num = n
cnt = 0

while True:
    a = num // 10
    b = num % 10
    c = (a+b) % 10
    num = int(str(b)+str(c))
    cnt += 1
    if n == num:
        print(cnt)
        break