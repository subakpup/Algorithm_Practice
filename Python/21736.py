from collections import deque
import sys
input = sys.stdin.readline

def bfs(start_x, start_y):
    queue = deque([(start_x, start_y)])
    visited[start_x][start_y] = True
    cnt = 0

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx,ny = x+dx[i], y+dy[i]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                if graph[nx][ny] != "X":
                    queue.append((nx,ny))
                    visited[nx][ny] = True
                    if graph[nx][ny] == "P":
                        cnt += 1
    return cnt

if __name__ == "__main__":
    n,m = map(int,input().split())
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    graph = []
    start_x,start_y = 0,0
    for i in range(n):
        r = list(input().strip())
        graph.append(r)
        for j in range(m):
            if r[j] == "I":
                start_x,start_y = i,j

    visited = [[False] * m for _ in range(n)]
    res = bfs(start_x,start_y)
    print(res if res > 0 else "TT")