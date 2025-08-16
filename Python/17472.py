"""Main_17472
# 문제 정리
 - N*M 지도
  - 0: 바다, 1: 땅
 - 다리
  - 바다에만 건설 가능
  - 1자 형태
  - 길이 2 이상
 - 모든 섬을 연결하는 다리 길이의 최솟값 출력

# 아이디어
 - 섬을 그룹화시키기 위해 각 섬에 번호 할당
 - 모든 섬을 일자로 연결
 - 중복되는 다리는 모두 제거(길이가 다를 경우 짧은 것만 남김)
"""
from collections import deque
import sys
input = sys.stdin.readline

dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

# 3. 섬 그룹화
def bfs(x,y):
    queue = deque([(x,y)]) # 시작 위치 삽입
    visited[x][y] = True # 방문 처리
    graph[x][y] = number # 라벨링

    while queue:
        r,c = queue.popleft()
        for i in range(4): # 4방향 탐색
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < n and 0 <= nc < m and not visited[nr][nc] and graph[nr][nc] == 1: # 범위 내면서 방문하지 않고 섬일 경우
                queue.append((nr,nc)) # 다음 좌표 삽입
                visited[nr][nc] = True # 방문 처리
                graph[nr][nc] = number # 라벨링

# 5. 다리 연결하기
def search():
    bridge = set() # 정보를 저장할 set(중복을 없애기 위해 사용)

    for r in range(n):
        for c in range(m):
            if graph[r][c] > 1: # 섬을 만났을 경우
                start = graph[r][c] # 시작 섬
                for i in range(4): # 4방향 탐색
                    length = 0 # 다리 길이
                    nr, nc = r, c
                    while True:
                        nr += dr[i] # 1직선 탐색
                        nc += dc[i]

                        if not (0 <= nr < n and 0 <= nc < m): # 범위 밖일 경우 breeak
                            break

                        if graph[nr][nc] == start: # 뻗어 나갔는데 섬일 경우 break
                            break

                        if graph[nr][nc] == 0: # 바다일 경우
                            length += 1 # 다리 길이 증가
                            continue

                        if length >= 2: # 길이가 2를 넘길 경우
                            s = min(start, graph[nr][nc]) # 시작 지점
                            e = max(start, graph[nr][nc]) # 도착 지점
                            bridge.add((length, s, e)) # 다리 정보 저장(길이, 시작 섬, 도착 섬)
                        break
    
    return list(bridge) # 다리 정보 리턴

# 6. 중복되는 다리 제거
def setting(arr):
    dic = dict()
    for length, s, e in arr: # 다리 정보 추출
        key = (s, e) # 시작, 도착 섬을 키로 설정
        if key not in dic or length < dic[key]: # 키값이 딕셔너리에 없거나 더 짧은 다리일 경우
            dic[key] = length # 딕셔너리에 업데이트
    
    # 중복되는 다리를 제거했으면 리스트로 반환
    result = []
    for (s, e), length in dic.items():
        result.append((length, s, e))
    
    return result

def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
    return parents[x]

def union(a,b):
    a = find(a)
    b = find(b)
    if a != b:
        parents[b] = a

if __name__ == "__main__":
    # 1. 입력
    n,m = map(int,input().split()) # 가로, 세로 길이
    graph = [list(map(int,input().split())) for _ in range(n)] # 섬과 바다 2차원 배열로 저장
    visited = [[False] * m for _ in range(n)] # 방문 여부
    
    # 2. 섬 그룹화
    number = 2 # 섬의 번호
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1 and not visited[i][j]: # 섬이면서 방문하지 않은 땅일 경우
                bfs(i,j)
                number += 1 # 이미 그룹화 했으니, 다음 번호로 설정
    
    # 4. 다리 연결
    bridge = search()
    bridge = setting(bridge)
    bridge.sort() # 정렬

    # 7. 유니온 파인드를 활용한 최소 신장 트리 형태로 섬 연결
    parents = [i for i in range(number)] # 부모 배열

    answer = 0 # 총 다리 길이

    for length, a, b in bridge:
        if find(a) != find(b): # 서로 다른 그룹이면 연결 가능
            union(a,b) # a,b 연결
            answer += length # 길이 증가

    # 8. 모두 연결되었는지 확인
    root = find(2) # 2번 섬을 부모로 설정
    for i in range(3, number):
        if find(i) != root: # 연결되어 있지 않다면
            answer = -1 # -1
            break
    
    # 9. 결과 출력
    print(answer)