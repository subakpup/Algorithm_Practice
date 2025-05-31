from collections import deque
import sys
input = sys.stdin.readline

def bfs(graph, visited, a, b):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    queue = deque([(a,b)])
    visited[a][b] = True
    
    while queue:
        x,y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and graph[x][y] == graph[nx][ny]:
                queue.append((nx,ny))
                visited[nx][ny] = True
    
    return 1

def counting(graph):
    visited = [[False] * n for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                cnt += bfs(graph, visited, i, j)
    
    return cnt

if __name__ == "__main__":
    n = int(input())
    RGB = [list(input().rstrip()) for _ in range(n)]
    RB = [['R' if r == 'G' else r for r in row] for row in RGB]        
    
    print(counting(RGB), counting(RB))