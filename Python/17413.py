import sys
input = sys.stdin.readline

s = input().split()

for i in range(len(s)):
    for j in s[i]:
        print((j[::-1]), end=' ')
    print()