t = int(input())
for tc in range(1, t+1):
    n = int(input())
    arr = [[0] * (n+1) for _ in range(n+1)]
    arr[1][1] = 1
    for i in range(2, n+1):
        for j in range(1, i+1):
            arr[i][j] = arr[i-1][j-1] + arr[i-1][j]

    print(f'#{tc}')
    for i in range(1, n+1):
        for j in range(1, i+1):
            print(arr[i][j], end=' ')
        print()