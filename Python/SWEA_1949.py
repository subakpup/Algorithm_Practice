dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

def dfs(r, c, length, flag):
    global answer
    visited[r][c] = True
    answer = max(answer, length)

    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]

        if 0 <= nr < n and 0 <= nc < n and not visited[nr][nc]:
            if graph[r][c] > graph[nr][nc]:
                dfs(nr, nc, length + 1, flag)
            elif graph[r][c] > graph[nr][nc] - k and flag:
                tmp = graph[nr][nc]
                graph[nr][nc] = graph[r][c] - 1
                dfs(nr, nc, length + 1, False)
                graph[nr][nc] = tmp
    
    visited[r][c] = False


for tc in range(1, int(input())+1):
    n,k = map(int, input().split())
    graph = [list(map(int, input().split())) for _ in range(n)]

    mx = 0
    for i in range(n):
        mx = max(mx, max(graph[i]))
    
    start = []
    for i in range(n):
        for j in range(n):
            if graph[i][j] == mx:
                start.append((i,j))
    
    answer = 0
    visited = [[False] * n for _ in range(n)]
    for r,c in start:
        dfs(r, c, 1, True)

    print(f'#{tc} {answer}')