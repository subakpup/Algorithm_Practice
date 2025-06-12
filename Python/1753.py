import sys, heapq
input = sys.stdin.readline

def func(start):
    queue = []
    dist[start] = 0
    heapq.heappush(queue, (0, start))
    
    while queue:
        dis, cur = heapq.heappop(queue)
        
        if dis > dist[cur]:
            continue
        
        for node, weight in graph[cur]:
            w = weight + dis
            if w < dist[node]:
                dist[node] = w
                heapq.heappush(queue, (w, node))

if __name__ == "__main__":
    a,b = map(int,input().split())
    k = int(input())
    graph = [[] for _ in range(a+1)]
    dist = [1e9] * (a+1)
    
    for _ in range(b):
        u,v,w = map(int,input().split())
        graph[u].append((v,w))
    
    func(k)
    
    for i in range(1, a+1):
        print(dist[i] if dist[i] != 1e9 else "INF")