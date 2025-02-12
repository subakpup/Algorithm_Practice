from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    queue = deque([(0,0)])

    while queue:
        x,y = queue.popleft()

        for i in range(4):
            nx,ny = x+dx[i], y+dy[i]
            if  0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx,ny))

if __name__ == "__main__":
    n,m = map(int,input().split())
    graph = [list(map(int,input().rstrip())) for _ in range(n)]

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    bfs()
    print(graph[n-1][m-1])