for tc in range(1,11):
    n = int(input())
    arr = [list(map(int,input().split())) for _ in range(100)]
    res = 0

    for i in range(100):
        #행
        row = sum(arr[i])
    
        #열
        col = sum(arr[j][i] for j in range(100))

        res = max(res, row, col)
    
    #하향 대각선
    down = sum(arr[i][i] for i in range(100))
    res = max(res, down)

    #상향 대각선
    up = sum(arr[i][99-i] for i in range(100))
    res = max(res, up)

    print(f'#{tc} {res}')