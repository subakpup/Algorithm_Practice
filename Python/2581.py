import sys
input = sys.stdin.readline

m = int(input())
n = int(input())
res = []
for i in range(m, n+1):
    arr = []
    for j in range(1, i+1):
        if i % j == 0:
            arr.append(j)
    if len(arr) == 2:
        res.append(i)
if res:
    print(sum(res))
    print(res[0])
else:
    print(-1)