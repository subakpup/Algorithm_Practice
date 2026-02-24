import sys
input = sys.stdin.readline

for _ in range(int(input())):
    credit = 0
    grade = 0.0
    n = int(input())
    for i in range(n):
        c,g = map(float,input().split())
        credit += int(c)
        grade += g * c
    print('%d %.1f' % (credit, (grade/credit)))