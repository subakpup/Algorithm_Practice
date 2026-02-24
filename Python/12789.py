from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
stk = deque(map(int,input().split()))
tmp = []
cnt = 1

while stk:
    if stk[0] == cnt:
        stk.popleft()
        cnt += 1
    else:
        tmp.append(stk.popleft())

    while tmp:
        if tmp and tmp[-1] == cnt:
            tmp.pop()
            cnt += 1
        else:
            break
print('Nice' if not tmp else 'Sad')