import sys
input = sys.stdin.readline

def func(n):
    if n < 1:
        return 1
    return n * func(n-1)

n = int(input())
s = str(func(n))
cnt = 0

for i in range(len(s)-1,-1,-1):
    if s[i] != '0':
        break
    cnt += 1
print(cnt)