t = int(input())
for tc in range(1, t+1):
    n,m = map(int,input().split())
    arr = [list(map(int,input().split())) for _ in range(n)]
    res = 0
    for i in range(n-m+1):
        for j in range(n-m+1):
            tmp = 0
            for k in range(m):
                tmp += sum(arr[i+k][j:j+m])
            res = max(res, tmp)

    print(f"#{tc} {res}")