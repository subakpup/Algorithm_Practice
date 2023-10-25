import sys
input = sys.stdin.readline

N,M = map(int,input().split())
n = list(map(int,input().split()))
lt, rt = 0, max(n)

while lt <= rt:
    mid = (lt+rt)//2
    cnt = 0

    for i in n:
        if i >= mid:
            cnt += i - mid
    
    if cnt < M:
        rt = mid - 1
    else:
        lt = mid + 1
print(rt)