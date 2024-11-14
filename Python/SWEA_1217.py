for tc in range(1,11):
    _ = int(input())
    a,b = map(int,input().split())
    res = a**b
    print(f'#{tc} {res}')