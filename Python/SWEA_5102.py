from collections import deque

def bfs(graph, v, start, end):
    queue = deque([start])
    visited = [False] * (v+1)
    distance = [0] * (v+1)
    
    visited[start] = True
    
    while queue:
        cur = queue.popleft()
        
        if cur == end:
            return distance[cur]
        
        for node in graph[cur]:
            if not visited[node]:
                visited[node] = True
                queue.append(node)
                distance[node] = distance[cur] + 1
    
    return 0
        
t = int(input())
for tc in range(1, t+1):
    v,e = map(int,input().split())
    graph = [[] for _ in range(v+1)]
    for _ in range(e):
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
    
    s,g = map(int,input().split())
    
    answer = bfs(graph, v, s, g)
    print(f'#{tc} {answer}')