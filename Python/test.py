t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    arr = [list(map(int,input().split())) for _ in range(n)]
    arr90 = [[0] * n] * n
    arr180 = [[0] * n] * n
    arr270 = [[0] * n] * n

    for i in range(n):
        for j in range(n):
            arr90[i][j] = arr[n-j-1][i]
    print(arr90)