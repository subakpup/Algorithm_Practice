"""Main_1647 도시 분할 계획 (골드 4)
    - 메모리: 196076KB
    - 시간: 3100ms

# 문제 정리
    - N개의 집, 그들을 연결하는 M개의 길
    - 마을을 두 개의 분리된 마을로 분할해야 함
    - 각 분리된 마을 안에 있는 임의의 두 집 사이에 경로가 항상 존재해야 함

# 아이디어
    - 마을을 어떻게 분리시킬 지 고민이 많았습니다.
    - 최소 비용을 유지하면서 2개의 마을로 끊으려면 최소 신장 트리의 가장 가중치가 큰 값을 제거하면,
    - 2개의 마을로 나뉘게 됩니다.
    - 이는 어떤 부분을 잘라내도 최소 1개의 집을 유지할 수 있으므로 크루스칼 로직에서
    - 다른 로직을 추가하지 않아도 되므로 효율적이라 생각하여 이 방식을 사용했습니다.
"""

import sys
input = sys.stdin.readline

def make(n):
    p = [i for i in range(n+1)]
    s = [1] * (n + 1)
    return p, s

def find(p, x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(p, s, a, b):
    ra, rb = find(p, a), find(p, b)
    
    if ra == rb:
        return False
    
    if s[ra] < s[rb]:
        ra, rb = rb, ra
    
    p[rb] = ra
    s[ra] += s[rb]
    return True

def kruskal(n, edges):
    edges.sort()

    p, s = make(n)
    mst_cost = 0
    used_edges = 0
    max_w = 0 # 최대 비용

    for w, a, b in edges:
        if union(p, s, a, b):
            mst_cost += w
            used_edges += 1

            if w > max_w: # 최대 비용 업데이트
                max_w = w
            if used_edges == n - 1:
                break
    
    return mst_cost - max_w # 전체 최소 비용 중에서 최대 비용만 제거

if __name__ == "__main__":
    n, m = map(int, input().split())
    edges = []
    for _ in range(m):
        a, b, w = map(int, input().split())
        edges.append((w, a, b))
    
    print(kruskal(n, edges))
