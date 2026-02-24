t = int(input())
for tc in range(1, t+1):
    n = int(input())
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    graph = [[0] * n for _ in range(n)]

    x, y = 0, 0  # 시작 위치
    d = 0  # 방향

    for i in range(1, n*n+1):
        graph[x][y] = i
        x += dx[d]
        y += dy[d]

        if x < 0 or x >= n or y < 0 or y >= n or graph[x][y] != 0:
            x -= dx[d]
            y -= dy[d]
            d = (d + 1) % 4
            x += dx[d]
            y += dy[d]

    print(f'#{tc}')
    for n in graph:
        print(*n)
