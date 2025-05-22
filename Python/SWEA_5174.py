from collections import deque

def bfs(graph, start):
    visited = [False] * (e+2)
    queue = deque([start])
    cnt = 1

    visited[start] = True

    while queue:
        v = queue.popleft()

        for node in graph[v]:
            if not visited[node]:
                visited[node] = True
                queue.append(node)
                cnt += 1

    return cnt

t = int(input())
for tc in range(1, t+1):
    e,n = map(int,input().split())
    arr = list(map(int,input().split()))

    graph = [[] for _ in range(e+2)]
    for i in range(0,len(arr),2):
        graph[arr[i]].append(arr[i+1])

    answer = bfs(graph, n)
    print(f'#{tc} {answer}')