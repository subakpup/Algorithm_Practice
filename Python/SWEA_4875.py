def dfs(x, y):
    if x == r and y == c:
        return True

    visited[x][y] = True
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and graph[nx][ny] != 1:
            if dfs(nx, ny):
                return True
    return False

t = int(input())
for tc in range(1, t+1):
    n = int(input())
    graph = [list(map(int,input())) for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 2:
                s,g = i,j
            elif graph[i][j] == 3:
                r,c = i,j

    visited = [[False] * n for _ in range(n)]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    answer = dfs(s, g)
    print(f'#{tc} {1 if answer else 0}')