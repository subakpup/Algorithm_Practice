from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0 <= nx < m and 0 <= ny < n and box[nx][ny] == 0:
                queue.append((nx,ny))
                box[nx][ny] = box[x][y] + 1

if __name__ == "__main__":
    n,m = map(int,input().split())
    
    box = []
    queue = deque()
    for i in range(m):
        row = list(map(int,input().split()))
        box.append(row)
        for j in range(n):
            if row[j] == 1:
                queue.append((i,j))
    
    bfs()

    res = 0
    for r in box:
        if 0 in r:
            print(-1)
            exit()
        res = max(res, max(r))
    print(res-1)