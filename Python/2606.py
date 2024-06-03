import sys
input = sys.stdin.readline

def dfs(v):
    visited[v] = 1
    for next in range(1, n+1):
        if not visited[next] and graph[v][next]:
            dfs(next)

n = int(input())
m = int(input())
graph = [[0] * (n+1) for _ in range(n+1)]
visited = [0] * (n+1)

for i in range(m):
    x,y = map(int,input().split())
    graph[x][y] = 1
    graph[y][x] = 1

dfs(1)
print(sum(visited)-1)