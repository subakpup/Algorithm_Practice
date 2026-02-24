import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = list(map(int,input().split()))

num = [0]
for i in range(n):
    num.append(arr[i] + num[i])

for _ in range(m):
    i,j = map(int,input().split())
    print(num[j]-num[i-1])