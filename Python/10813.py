import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = [i for i in range(n+1)]
for i in range(m):
    a,b = map(int,input().split())
    arr[a], arr[b] = arr[b], arr[a]
del(arr[0])
print(*arr)