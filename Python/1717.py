""" Main_1717 집합의 표현 (골드 5)
- 메모리: 80416KB
- 시간: 292ms

# 문제 정리
    - 초기에 0 ~ n까지의 집합이 있다.
    - 합집합 연산, 두 원소가 같은 집합에 포함되어 있는지 확인하는 연산 수행
    - 집합을 표현하는 프로그램 작성
    - 합집합: `0 a b`
    - 두 원소가 같은 집합에 포함되어 있는지 확인: `1 a b`

# 아이디어
    - 유니온 파인드
    - 경로 압축 + size 기반 풀이
"""

import sys
input = sys.stdin.readline

# 1. 초기화: 자기 자신을 부모로 설정
# 루트, size 배열 선언
def make_set(n):
    parent = [i for i in range(n+1)]
    size = [1] * (n+1)
    return parent, size

# 2. Find 연산 (경로 압축)
def find(p, x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

# 3. Union 연산
def union(p, size, a, b):
    ra, rb = find(p, a), find(p, b) # a와 b의 루트

    if ra == rb: # 같다면 return
        return False

    if size[ra] < size[rb]: # rb의 사이즈가 더 크다면 swap
        ra, rb = rb, ra
    
    # 크기가 더 큰 ra를 rb의 루트로 할당
    p[rb] = ra # 루트 할당
    size[ra] += size[rb] # rb의 사이즈만큼 증가
    return True

if __name__ == "__main__":
    n,m = map(int, input().split())
    p, size = make_set(n)
    sb = [] # 출력

    for i in range(m):
        cmd, a, b = map(int, input().split())

        if cmd == 0: # 합 연산
            union(p, size, a, b)
        elif cmd == 1: # 두 원소의 루트 비교(같은 집합인가?)
            sb.append("YES" if find(p, a) == find(p, b) else "NO")
    
    print('\n'.join(sb))
