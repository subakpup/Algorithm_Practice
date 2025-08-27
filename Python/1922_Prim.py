"""Main_1922 네트워크 연결 (골드 4)
    - 메모리: 63016KB
    - 시간: 308ms

# 문제 정리
    - 컴퓨터와 컴퓨터를 모두 연결하는 네트워크를 구축하려 한다.
    - 컴퓨터를 연결하는데 필요한 비용이 주어졌을 때 모든 컴ㅍ터를 연결하는데 필요한 최소비용 출력

# 아이디어
    - 프림 알고리즘
    - 간선의 정보를 (가중치, 정점) 형태로 인접 리스트에 저장
    - 최소 heap을 이용해 가중치가 가장 작은 것부터 pop

"""

import sys, heapq
input = sys.stdin.readline

def prim(start, adj, n):
    visited = [False] * (n + 1) # 정점 방문 여부
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
    n = int(input())
    m = int(input())
    adj = [[] for _ in range(n + 1)] # 인접 리스트
    for _ in range(m):
        a, b, w = map(int, input().split())
        adj[a].append((w, b)) # 간선의 정보
        adj[b].append((w, a))

    print(prim(1, adj, n)) # 1번 정점부터 시작
