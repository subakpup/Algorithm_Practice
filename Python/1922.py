"""Main_1922 네트워크 연결 (골드 4)
    - 메모리: 47528KB
    - 시간 208ms

# 문제 정리
    - 도현이는 컴퓨터와 컴퓨터를 모두 연결하는 네트워크를 구축하려 함
    - 선을 이용해 모든 컴퓨터를 연결해야 함
        - a와 b가 연결되어 있다는 말은 a에서 b로의 경로가 존재한다는 것
    - 각 컴퓨터를 연결하는데 필요한 비용이 주어졌을 때, 모든 컴퓨터를 연결하는데 필요한 최소 비용을 출력

# 아이디어
    - 최소 신장 트리 알고리즘 이용
    - 실제 문제로 주어진다면, 이런 식으로 나올 것이다~ 라는 예시 문제 느낌입니다.
"""

import sys
input = sys.stdin.readline

# 부모, 집합의 크기 배열 초기화
def make(n):
    p = [i for i in range(n+1)]
    s = [1] * (n+1)
    return p, s

# x의 부모를 찾는 함수
def find(p, x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

# a와 b를 하나의 집합으로 묶는 함수
def union(p, s, a, b):
    ra, rb = find(p, a), find(p, b) # a, b의 부모

    if ra == rb: # 부모가 같다면 == 같은 집합이라면 False return
        return False
    
    # ra와 rb가 다른 그룹이라면
    # rb를 ra의 그룹으로 묶으려 한다.
    # 그러려면 ra의 크기가 rb보다 같거나 커야 하므로
    # rb가 더 큰 경우엔 swap이 필요함
    if s[ra] < s[rb]:
        ra, rb = rb, ra
    
    p[rb] = ra # rb의 부모를 ra로 설정
    s[ra] += s[rb] # rb가 ra 밑으로 들어갔으니, ra의 크기를 rb의 크기만큼 증가
    return True # union을 실행했으니, True return

# 최소 신장 트리 함수
def kruskal(n, edges):
    # edges = [(w, a, b)]
    edges.sort() # 가중치 기준 오름차순 정렬

    mst_cost = 0 # 비용
    used_edges = 0 # 사용한 간선 수

    for w, a, b in edges:
        if union(p, s, a, b): # union을 실행했다면,
            mst_cost += w # 가중치 만큼 비용 발생
            used_edges += 1 # 사용한 간선 수 + 1

            if used_edges == n - 1: # 간선 수가 n-1이 됐다면 트리 완성
                break
    
    return mst_cost # 비용 리턴

if __name__ == "__main__":
    n = int(input()) # 컴퓨터 수
    m = int(input()) # 선의 수
    edges = [] # 가중치, a -> b 연결
    for _ in range(m):
        a, b, w = map(int, input().split())
        edges.append((w, a, b))
    
    p,s = make(n) # 부모, 크기 배열
    print(kruskal(n, edges))
