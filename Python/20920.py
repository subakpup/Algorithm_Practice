import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = []
for _ in range(n):
    s = input().rstrip()
    if len(s) >= m:
        arr.append(s)

dic = dict()
for i in arr:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1
res = sorted(dic.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))

for key,value in res:
    print(*key, sep='')