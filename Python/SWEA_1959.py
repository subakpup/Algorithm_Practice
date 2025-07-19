def func(n,m,a,b):
    res = 0
    for i in range(m-n+1):
        tmp = 0
        for j in range(n):
            tmp += a[j] * b[i+j]
        res = max(res, tmp)
    return res

for tc in range(1, int(input())+1):
    N,M = map(int,input().split())
    A = list(map(int,input().split()))
    B = list(map(int,input().split()))
    
    if N<M:
        answer = func(N,M,A,B)
    else:
        answer = func(M,N,B,A)
    
    print(f'#{tc} {answer}')