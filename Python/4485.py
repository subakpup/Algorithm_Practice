"""Main_4485 녹색 옷 입은 애가 젤다지? (골드 4)
 - 메모리: 34968KB
 - 시간: 272ms

# 문제 정리
 - 화폐
  1. 루피
  2. 도둑 루피(획득하면 돈을 잃음)
 - 도둑루피만 있는 N*N 동굴
 - 시작 좌표(0, 0), 도착 좌표 (n-1, n-1)
 - 잃는 금액을 최소로 하여 이동
 - 상하좌우 이동 가능

# 아이디어
 - 최소 비용만을 사용하여 최단 거리를 탐색하면 되겠다 !
 - 다익스트라 알고리즘 활용(큐로 구현)
"""
from collections import deque
import sys
input = sys.stdin.readline

tc = 1 # 테스트 케이스
dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

def bfs():
    queue = deque([(0,0)]) # 초기값 설정
    ind = [[int(1e9)] * n for _ in range(n)] # 최소 비용을 저장할 배열
    ind[0][0] = graph[0][0] # 시작 지점 최소 비용

    while queue:
        r,c = queue.popleft()
        
        for i in range(4): # 4방향 탐색
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < n and 0 <= nc < n: # 범위 내일 경우 탐색
                tmp = graph[nr][nc] + ind[r][c] # 다음으로 이동할 좌표의 비용 + 현재까지의 최소 비용
                if tmp < ind[nr][nc]: # 다음 좌표까지의 최소 비용 합보다 작을 경우
                    ind[nr][nc] = tmp # 값 갱신
                    queue.append((nr,nc))
    
    return ind[n-1][n-1]

while True:
    n = int(input())
    if (n == 0): break # 0 입력 시 종료
    graph = [list(map(int,input().split())) for _ in range(n)] # N*N 동굴
    print(f"Problem {tc}: {bfs()}")
    tc += 1