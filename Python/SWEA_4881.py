def func(row, total):
    global res
    if total >= res:
        return
    
    if row == n:
        res = min(res, total)
        return
    
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            func(row + 1, total + arr[row][i])
            visited[i] = False

t = int(input())
for tc in range(1, t+1):
    n = int(input())
    arr = [list(map(int,input().split())) for _ in range(n)]
    visited = [False] * n
    res = 1e9
    
    func(0,0)
    
    print(f'#{tc} {res}')