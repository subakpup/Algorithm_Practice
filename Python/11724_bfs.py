from collections import deque
import sys
input = sys.stdin.readline

def bfs(v):
    queue = deque([v])
    visited[v] = 1

    while queue:
        node = queue.popleft()
        for i in range(1,n+1):
            if graph[node][i] == 1 and visited[i] == 0:
                queue.append(i)
                visited[i] = 1
    
if __name__ == "__main__":
    n,m = map(int,input().split())
    graph = [[0] * (n+1) for _ in range(n+1)]
    visited = [0] * (n+1)
    for _ in range(m):
        a,b = map(int,input().split())
        graph[a][b] = graph[b][a] = 1

    cnt = 0
    for i in range(1,n+1):
        if visited[i] == 0:
            bfs(i)
            cnt += 1
    print(cnt)