import sys
input = sys.stdin.readline

n,x = map(int,input().split())
a = list(map(int,input().split()))
res = []

for i in a:
    if i < x:
        res.append(i)
print(*res)