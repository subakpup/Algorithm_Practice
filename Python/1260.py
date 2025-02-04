from collections import deque
import sys
input = sys.stdin.readline

def dfs(v):
    visited[v] = 1
    print(v, end=" ")
    for i in range(1,n+1):
        if graph[v][i] == 1 and visited[i] == 0:
            dfs(i)

def bfs(v):
    queue = deque([v])
    visited2[v] = 1
    while queue:
        node = queue.popleft()
        print(node, end=" ")
        for i in range(1,n+1):
            if graph[node][i] == 1 and visited2[i] == 0:
                queue.append(i)
                visited2[i] = 1

if __name__ == "__main__":
    n,m,v = map(int,input().split())
    graph = [[0]*(n+1) for _ in range(n+1)]
    visited = [0] * (n+1)
    visited2 = visited.copy()

    for i in range(m):
        a,b = map(int,input().split())
        graph[a][b] = graph[b][a] = 1

    dfs(v)
    print()
    bfs(v)