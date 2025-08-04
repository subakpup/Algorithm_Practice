from collections import deque
import sys
input = sys.stdin.readline

def bfs(X,Y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    area = 1

    queue = deque([(X,Y)])
    visited[X][Y] = True

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx,ny))
                area += 1
    return area


if __name__ == "__main__":
    n,m = map(int,input().split())
    arr = [list(map(int,input().split())) for _ in range(n)]
    visited = [[False] * m for _ in range(n)]

    cnt = 0
    answer = 0
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 1 and not visited[i][j]:
                answer = max(answer, bfs(i,j))
                cnt += 1

    print(cnt)
    print(answer)
