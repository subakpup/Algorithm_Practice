for tc in range(1,11):
    arr = [list(map(int,input().split())) for _ in range(100)]
    sum_lst = set()
    #행
    for r in range(100):
        sum_lst.add(sum(arr[r]))
    
    #열
    for i in range(100):
        summation = 0
        for j in range(100):
            summation += arr[i][j]
        sum_lst.add(summation)
    
    #하향 대각선
    line_down = 0
    for i in range(100):
        line_down += arr[i][i]
    sum_lst.add(line_down)

    #상향 대각선
    line_up = 0
    for j in range(99, -1, -1):
        line_up += arr[i][i]
    sum_lst.add(line_up)

    #결과
    res = max(sum_lst)

    #결과 출력
    print(f'#{tc} {res}')