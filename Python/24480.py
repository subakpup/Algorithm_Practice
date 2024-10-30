import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

def dfs(graph,v,visited):
    global c
    visited[v] = 1
    cnt[v] = c
    c += 1
    for i in graph[v]:
        if visited[i] == 0:
            dfs(graph,i,visited)

if __name__ == '__main__':
    n,m,r = map(int,input().split())
    visited = [0] * (n+1)
    cnt = [0] * (n+1)
    c = 1
    
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
    
    for i in range(1,n+1):
        graph[i].sort(reverse=True)
    
    dfs(graph,r,visited)

    for j in range(1, n+1):
        print(cnt[j])