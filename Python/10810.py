import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = [0 for i in range(n+1)]

for i in range(m):
    a,b,c = map(int,input().split())
    for i in range(a, b+1):
        arr[i] = c
del(arr[0])
print(*arr)