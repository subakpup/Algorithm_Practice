import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int,input().split()))
stk = []
target = 1

for i in a:
    stk.append(i)
    while stk and stk[-1] == target:
        stk.pop()
        target += 1
    if len(stk) > 1 and stk[-1] > stk[-2]:
        break
if stk:
    print("Sad")
else:
    print("Nice")