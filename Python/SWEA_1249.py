"""Solution_1249 보급로 (D4)
# 문제 정리
 - 출발지에서 도착지까지 가는 경로 중, 복구 시간이 가장 짧은 경로에 대한 총 복구시간
 - 깊이가 1이면 복구에 드는 시간은 1

# 아이디어
 - 가중치를 계산한 최단경로 문제
 - 그래프와 같은 사이즈인 배열을 하나 더 만들어 이용하자
 - 4방향을 모두 탐색하여 최솟값 갱신
"""
from collections import deque

# 4방향 탐색
dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

# BFS 탐색
def bfs():
    queue = deque([(0,0)]) # 시작 지점
    arr = [[int(1e9)] * n for _ in range(n)] # 최솟값을 구하기 위한 배열
    arr[0][0] = 0 # 시작 지점 초기화

    while queue:
        r, c = queue.popleft()

        for i in range(4): # 4방향 탐색
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < n and 0 <= nc < n: # 범위 내에 존재한다면 모두 탐색
                tmp = arr[r][c] + graph[nr][nc] # 현재 위치의 복구 시간 + 이동하려는 곳의 복구 시간
                if tmp < arr[nr][nc]: # 이동하려는 곳의 현재 복구 시간보다 짧다면 업데이트
                    arr[nr][nc] = tmp
                    queue.append((nr, nc))

    return arr[n-1][n-1] # 탐색을 마치면 도착 지점의 최소 복구 시간 리턴
                
for tc in range(1, int(input())+1):
    n = int(input())
    graph = [list(map(int,input())) for _ in range(n)]

    print(f"#{tc} {bfs()}")