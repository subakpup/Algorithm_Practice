import sys
input = sys.stdin.readline

n,k = map(int,input().split())
arr = list(map(int,input().split()))

num = [0]
tmp = 0
for i in arr:
    tmp += i
    num.append(tmp)

res = []
for i in range(n-k+1):
    res.append(num[i+k]-num[i])

print(max(res))