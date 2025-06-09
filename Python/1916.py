import sys, heapq
input = sys.stdin.readline

def func(start):
    queue = []
    heapq.heappush(queue, (0, start))
    distance[start] = 0
    
    while queue:
        dist, cur = heapq.heappop(queue)
        
        if dist > distance[cur]:
            continue
        
        for next, cost in graph[cur]:
            new_cost = dist + cost
            
            if new_cost < distance[next]:
                distance[next] = new_cost
                heapq.heappush(queue, (new_cost, next))


if __name__ == "__main__":
    n = int(input())
    m = int(input())
    graph = [[] for _ in range(n+1)]

    for _ in range(m):
        s,t,c = map(int,input().split())
        graph[s].append((t,c))
    
    start, target = map(int,input().split())
    distance = [1e9] * (n+1)

    func(start)
    print(distance[target])