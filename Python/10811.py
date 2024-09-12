import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = [i for i in range(n+1)]

for _ in range(m):
    a,b = map(int,input().split())
    arr = arr[0:a] + list(reversed(arr[a:b+1])) + arr[b+1:n+1]
del(arr[0])
print(*arr)