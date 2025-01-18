import sys
input = sys.stdin.readline

s = input().strip().split('-')
sub = []

for i in s:
    cnt = 0
    for j in i.split('+'):
        cnt += int(j)
    sub.append(cnt)

res = sub[0]
for r in sub[1:]:
    res -= r
print(res)