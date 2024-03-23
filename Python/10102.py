import sys
input = sys.stdin.readline

v = int(input())
t = list(map(str,input().upper().rstrip()))

a = t.count('A')
b = t.count('B')

if a > b:
    print('A')
elif a < b:
    print('B')
else:
    print('Tie')