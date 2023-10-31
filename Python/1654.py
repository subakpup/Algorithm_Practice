import sys
input = sys.stdin.readline

k,n = map(int,input().split())
arr = [int(input()) for _ in range(k)]
lt, rt = 1, max(arr)

while lt <= rt:
    mid = (lt+rt)//2
    lan = 0
    for i in arr:
        lan += i // mid

    if lan >= n:
        lt = mid + 1
    else:
        rt = mid - 1
print(rt)