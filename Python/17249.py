import sys
input = sys.stdin.readline

s = input().strip().split('(^0^)')
for i in range(2):
    print(s[i].count('@'), end=' ')