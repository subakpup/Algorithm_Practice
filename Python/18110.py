import sys
input = sys.stdin.readline

def round(n):
    if n - int(n) >= 0.5:
        return int(n) + 1
    else:
        return int(n)

n = int(input())
arr = [int(input()) for _ in range(n)]
arr.sort()

if n == 0:
    print(0)
else:
    val = round(n*0.15)
    arr = arr[val:n-val]
    print(round(sum(arr)/len(arr)))