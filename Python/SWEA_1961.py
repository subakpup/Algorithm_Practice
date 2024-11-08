def change(n, arr):
    res = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            res[i][j] = arr[n-j-1][i]
    return res

t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    arr = [list(map(int,input().split())) for _ in range(n)]
    arr90 = change(n, arr)
    arr180 = change(n, arr90)
    arr270 = change(n, arr180)

    print(f'#{test_case}')
    for i in range(n):
        for a in range(n):
            print(arr90[i][a], end='')
        print(end=' ')
        for b in range(n):
            print(arr180[i][b], end='')
        print(end=' ')
        for c in range(n):
            print(arr270[i][c], end='')
        print()
