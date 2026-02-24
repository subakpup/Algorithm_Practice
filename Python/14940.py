from collections import deque
import sys
input = sys.stdin.readline

def bfs(X,Y):
    queue = deque([(X,Y)])
    visited[X][Y] = 0

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx,ny = x+dx[i], y+dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if visited[nx][ny] == -1 and graph[nx][ny] == 1:
                    queue.append((nx,ny))
                    visited[nx][ny] = visited[x][y] + 1

if __name__ == "__main__":
    n,m = map(int,input().split())

    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    graph = []
    x,y = 0,0

    for i in range(n):
        row = list(map(int,input().split()))
        graph.append(row)
        for j in range(m):
            if row[j] == 2:
                x,y = i,j

    visited = [[-1 if graph[i][j] == 1 else 0 for j in range(m)] for i in range(n)]

    bfs(x,y)
    for row in visited:
        print(*row)