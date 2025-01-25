import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = list(map(int,input().split()))

tmp = 0
pre = [0] * m
pre[0] = 1
res = 0

for i in arr:
    tmp += i
    mod = tmp % m

    res += pre[mod]
    pre[mod] += 1

print(res)