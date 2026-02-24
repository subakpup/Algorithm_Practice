t = int(input())
for tc in range(1,t+1):
    a,b,n = map(int,input().split())
    cnt = 0
    while a <= n and b <= n:
        if a < b:
            a += b
        else:
            b += a
        cnt += 1
    print(cnt)