import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = list(map(int,input().split()))
num = [0]
tmp = 0

for i in arr:
    tmp += i
    num.append(tmp)

for _ in range(m):
    a,b = map(int,input().split())
    print(num[b] - num[a-1])