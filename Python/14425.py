import sys
input = sys.stdin.readline

n,m = map(int,input().split())
cnt = 0
s = []

for _ in range(n):
    s.append(input().rstrip())
for _ in range(m):
    chk = input().rstrip()
    if chk in s:
        cnt += 1

print(cnt)