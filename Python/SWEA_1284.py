t = int(input())
for tc in range(1,t+1):
    # p = 리터당 요금
    # q = 기본 요금, r리터 초과시 리터당 s 추가
    # w = 사용 요금 
    p,q,r,s,w = map(int,input().split())
    a = p * w
    b = q
    if r < w:
        b = (w - r) * s + q
    
    if a > b:
        res = b
    else:
        res = a
    print(f'#{tc} {res}')