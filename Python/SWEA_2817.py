def func(i,total):
    global cnt
    if i == n:
        if total == k:
            cnt += 1
        return
    func(i+1, total + a[i])
    func(i+1, total)
    
t = int(input())
for tc in range(1, t+1):
    n,k = map(int,input().split())
    a = list(map(int,input().split()))

    cnt = 0
    func(0,0)
    print(f'#{tc} {cnt}')