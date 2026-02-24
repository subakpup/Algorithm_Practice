import sys
input = sys.stdin.readline

s = input().strip()
d = list(input().strip())
stk = []

for i in s:
    stk.append(i)
    if stk[len(stk)-len(d):len(stk)] == d:
        for _ in range(len(d)):
            stk.pop()

if stk:
    print(*stk, sep='')
else:
    print("FRULA")