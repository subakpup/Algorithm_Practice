from collections import deque
import sys
input = sys.stdin.readline

def bfs(graph, x, y):
    queue = deque()
    queue.append((x,y))
    graph[x][y] = 0
    cnt = 1

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx,ny))
                cnt += 1
    return cnt

n = int(input())
graph = [list(map(int,input().rstrip())) for _ in range(n)]
result = []
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            result.append(bfs(graph, i, j))

result.sort()
print(len(result))
for k in result:
    print(k)