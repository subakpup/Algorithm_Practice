"""Main_1197 최소 스패닝 트리 (골드 4)
    - 메모리: 49576KB
    - 시간: 240ms

# 문제 정리
    - 그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하라
    - 최소 스패닝 트리란?
        - 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중, 가중치의 합이 최소인 트리
    - 정점의 개수 V, 간선의 개수 E

# 아이디어
    - Union-Find를 이용해 사이클을 돌 수 없는 그래프를 만들자
    - 간선의 개수가 V-1개가 된다면 종료하자
"""
import sys
input = sys.stdin.readline

# 부모, 사이즈 배열 초기화
def make(n):
    p = [i for i in range(n+1)]
    size = [1] * (n+1)
    return p, size

# x의 부모를 찾는 함수
def find(p, x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

# a와 b를 하나의 집합으로 묶는 함수
def union(p, s, a, b):
    ra, rb = find(p, a), find(p, b) # a의 부모, b의 부모

    if ra == rb: # 부모가 같다면(같은 집합이라면) False return
        return False
    
    if s[ra] < s[rb]: # rb의 사이즈가 ra의 사이즈보다 크다면 swap
        ra, rb = rb, ra
    
    p[rb] = ra # rb의 부모를 ra로 할당(ra의 그룹으로 할당)
    s[ra] += s[rb] # rb가 ra의 밑으로 들어갔으니 크기 업데이트
    return True # union을 했으니 True return

# 최소 신장 트리
def kruskal(n, edges):
    edges.sort() # 가중치 기준 오름차순 정렬

    mst_cost = 0 # 트리를 만드는 데 사용한 비용
    used_edges = 0 # 사용한 간선의 개수

    for w, a, b in edges:
        if union(p, s, a, b): # union을 했다면
            mst_cost += w # 비용 가중치만큼 증가
            used_edges += 1 # 간선의 개수 + 1
            
            if used_edges == n - 1: # 간선의 개수가 최대라면 break
                break

    return mst_cost # 비용 리턴

if __name__ == "__main__":
    v, e = map(int, input().split())
    
    edges = []
    for _ in range(e):
        a, b, w = map(int, input().split())
        edges.append((w, a, b))

    p, s = make(v)
    print(kruskal(v, edges))
