for tc in range(1,11):
    n = int(input())
    ARR = [list(map(int,input().split())) for _ in range(n)]
    arr = list(map(list, zip(*ARR)))

    cnt = 0
    for i in range(n):
        arr[i] = [num for num in arr[i] if num != 0]
        for j in range(len(arr[i])-1):
            if arr[i][j] == 1 and arr[i][j+1] == 2:
                cnt += 1
    
    print(f'#{tc} {cnt}')