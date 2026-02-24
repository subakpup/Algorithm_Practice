from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
m = int(input())
c = list(map(int,input().split()))

res = deque()
for i in range(n):
    if a[i] == 0:
        res.appendleft(b[i])

for j in range(m):
    res.append(c[j])
    print(res.popleft(), end=' ')