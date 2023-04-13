import sys
input = sys.stdin.readline

n,m = map(int,input().split())

arr = [i for i in range(n+1)]

for _ in range(m):
    i,j = map(int,input().split())
    arr[i:j+1] = reversed(arr[i:j+1])

arr.remove(arr[0])
print(*arr)