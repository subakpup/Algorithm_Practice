from collections import deque
import sys
input = sys.stdin.readline

def bfs(x,y):
    queue = deque([(x,y)])
    graph[x][y] = 0
    cnt = 1

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx,ny = x+dx[i], y+dy[i]
            if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 1:
                queue.append((nx,ny))
                graph[nx][ny] = 0
                cnt += 1
    
    return cnt

if __name__ == "__main__":
    n = int(input())
    graph = [list(map(int,input().rstrip())) for _ in range(n)]

    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    res = []
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 1:
                res.append(bfs(i,j))
    res.sort()

    print(len(res))
    for r in res:
        print(r)