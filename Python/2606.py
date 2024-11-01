import sys
input = sys.stdin.readline

def dfs(v):
    visited[v] = 1
    for i in graph[v]:
        if visited[i] == 0:
            dfs(i)

if __name__ == '__main__':
    n = int(input())
    v = int(input())
    graph = [[] for _ in range(n+1)]
    visited = [0] * (n+1)
    for i in range(v):
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
    dfs(1)
    print(sum(visited)-1)