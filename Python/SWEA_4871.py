from collections import deque

def dfs(s, g, graph, visited):
    if s == g:
        return True
    visited[s] = True
    for node in graph[s]:
        if not visited[node]:
            if dfs(node, g, graph, visited):
                return True
    return False

t = int(input())
for tc in range(1, t+1):
    v,e = map(int,input().split())
    graph = [[] * (v+1) for _ in range(v+1)]

    for i in range(e):
        a,b = map(int,input().split())
        graph[a].append(b)

    s,g = map(int,input().split())
    visited = [False] * (v+1)
    answer = dfs(s, g, graph, visited)

    print(f'#{tc} {1 if answer else 0}')