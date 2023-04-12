import sys
input = sys.stdin.readline

a = []
b = []

n,m = map(int,input().split())

for i in range(n):
    arr = list(map(int,input().split()))
    a.append(arr)

for i in range(n):
    arr = list(map(int,input().split()))
    b.append(arr)


for i in range(n):
    for j in range(m):
        a[i][j] += b[i][j]

for i in range(n):
    print(*a[i])