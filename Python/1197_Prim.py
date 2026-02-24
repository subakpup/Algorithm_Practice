"""Main_1197 최소 스패닝 트리 (골드 4)
    - 메모리: 66532KB
    - 시간: 336ms

# 문제 정리
    - 그래프가 주어졌을 때, 최소 스패닝 트리를 구하라

# 아이디어
    - 프림 알고리즘
    - 간선의 정보를 (가중치, 정점) 형태로 인접 리스트에 저장
    - 최소 heap을 이용해 가중치가 가장 작은 것부터 pop
"""

import sys, heapq
input = sys.stdin.readline

def prim(start, adj, n):
    visited = [False] * (n+1) # 정점 방문 여부
    min_heap = [(0, start)] # 가중치, 정점
    mst_cost = 0
    cnt = 0

    while min_heap and cnt < n: 
        w, u = heapq.heappop(min_heap)

        if visited[u]: # 이미 연결된 정점이라면 pass
            continue

        visited[u] = True
        mst_cost += w
        cnt += 1

        for w2, v in adj[u]: # 현재 정점과 인접한 정점 탐색
            if not visited[v]: # 연결되어 있지 않다면
                heapq.heappush(min_heap, (w2, v)) # heappush
    
    return mst_cost

if __name__ == "__main__":
    v, e = map(int, input().split())
    adj = [[] for _ in range(v + 1)] # 인접 리스트
    for _ in range(e):
        a, b, w = map(int, input().split())
        adj[a].append((w, b)) # 간선의 정보
        adj[b].append((w, a))
    
    print(prim(1, adj, v)) # 1번 정점부터 시작
