import sys
input = sys.stdin.readline

a,b = map(int,input().split())
c = int(input())
b += c
while True:
    if b < 60:
        break
    a += 1
    b -= 60
    if a > 23:
        a -= 24

print(a,b)