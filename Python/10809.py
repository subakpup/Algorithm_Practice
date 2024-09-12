import sys
input = sys.stdin.readline

s = input()
abc = 'abcdefghijklmnopqrstuvwxyz'

for i in abc:
    if i in s:
        print(s.index(i), end=' ')
    else:
        print(-1, end=' ')