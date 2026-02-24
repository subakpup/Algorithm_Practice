def binarySearch(p,v):
    l,r = 1,p
    cnt = 0

    while l <= r:
        cnt += 1
        mid = int((l+r)/2)
        if mid < v:
            l = mid
        elif mid > v:
            r = mid
        else:
            return cnt

t = int(input())
for tc in range(1, t+1):
    p,a,b = map(int,input().split())

    A = binarySearch(p,a)
    B = binarySearch(p,b)

    if A > B:
        result = "B"
    elif A < B:
        result = "A"
    else:
        result = "0"

    print(f'#{tc} {result}')