"""Main_1976 여행 가자 (골드 4)
- 메모리: 32412KB
- 시간: 40ms

# 문제 정리
    - N개의 도시
        - 길이 있을 수도, 없을 수도 있다.
    - 여행 일정이 주어졌을 때, 여행 경로가 **가능한 것인지** 알아보자
    - 도시들의 개수와 도시들 간의 연결 여부가 주어짐
    - 도시들이 순서대로 주어졌을 때 가능한지 여부 출력

# 아이디어
    - 유니온 파인드
    - 사이즈 기반 풀이
"""
import sys
input = sys.stdin.readline

# 1. 초기화: 자기 자신을 부모로 설정, 자신의 크기 1로 초기화
def make_set(n):
    parent = [i for i in range(n+1)]
    size = [1] * (n+1)
    return parent, size

# 2. Find 연산 (경로 압축)
def find(p, x):
    while p[x] != x: # 자신의 부모가 자신이 아닐 경우
        p[x] = p[p[x]] # 현재 부모를 "부모의 부모"로 설정 (경로 압축)
        x = p[x] # 새 부모로 x 할당
    return x

# Union 연산
def union(p, size, a, b):
    ra, rb = find(p, a), find(p, b) # a의 루트와 b의 루트

    if ra == rb: # 이미 부모가 같다면 리턴
        return False
    
    if size[ra] < size[rb]: # ra >= rb 일 경우에 루트를 ra로 업데이트 시키기 위해 swap
        ra, rb = rb, ra

    # rb의 루트를 ra로 설정
    p[rb] = ra # 값 업데이트
    size[ra] += size[rb] # ra의 사이즈에 rb 사이즈 추가
    return True

if __name__ == "__main__":
    n = int(input()) # 도시의 수
    m = int(input()) # 여행 계획에 속한 도시들의 수
    
    p, size = make_set(n) # 부모, 사이즈 초기화
    for i in range(1, n+1):
        c = [0] + list(map(int, input().split())) # 1-index
        for j in range(n): # 도시의 수만큼 입력을 받으므로
            if j == i:
                continue
            if c[j] == 1: # 다른 도시와 연결
                union(p, size, i, j)
    
    route = list(map(int, input().split()))
    r = find(p, route[0]) # 입력 받은 첫 번째 도시와 비교
    answer = "YES"
    for i in range(1, m):
        if r != find(p, route[i]): # 루트가 다르다면 (연결되어 있지 않다면)
            answer = "NO"
            break
    print(answer)
