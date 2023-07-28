import sys
input = sys.stdin.readline

arr = []
n,k = map(int,input().split())
for i in range(1, n+1):
    if n%i == 0:
        arr.append(i)

if len(arr) < k:
    print(0)
else:
    print(arr[k-1])