# 시간 초과
import sys
input = sys.stdin.readline

res = {}
s = input().upper()

for i in s:
    res[i] = s.count(i)

if list(res.values()).count(max(res.values())) > 1:
    print('?')
else:
    print(max(res))