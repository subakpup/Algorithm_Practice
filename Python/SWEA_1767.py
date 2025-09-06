dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

def dfs(depth, r, c, dist, d):
    global idx
    if depth == len(start):
        return dist

    cnt = 0
    while True:
        nr = r + dr[d]
        nc = c + dc[d]
        if nr < 0 or nr >= n or nc < 0 or nc >= n or board[nr][nc] == 1:
            break
        board[nr][nc] = 1
        cnt += 1
    
    idx += 1
    dfs(depth + 1, start[idx][0], start[idx][1], dist + cnt, d)

for tc in range(1, int(input())+1):
    n = int(input())
    board = [list(map(int,input().split())) for _ in range(n)]

    idx = 0
    start = []
    for i in range(1, n-1):
        for j in range(1, n-1):
            if board[i][j] == 1:
                start.append((i, j))
    