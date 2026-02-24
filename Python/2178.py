"""Main_2178 미로 탐색 (실버 1)
 - 메모리: 35100KB
 - 시간: 64ms

# 문제 정리
 - N*M 미로
 - 1: 이동 가능, 0: 이동 불가
 - (1,1)에서 출발하여 (N,M)까지의 최소 칸 수

# 아이디어
 - 이동할 수 있는 칸이 1이므로 값을 더하며 최소 비용을 구하면 되겠다 !
"""
from collections import deque
import sys
input = sys.stdin.readline

dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

# BFS 탐색
def bfs():
    queue = deque([(0,0)]) # 출발점 삽입
    ind = [[int(1e9)] * m for _ in range(n)] # 최소 비용을 저장할 배열
    ind[0][0] = graph[0][0] # 시작 지점 값 삽입

    while queue:
        r,c = queue.popleft()
        for i in range(4): # 4방향 탐색
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < n and 0 <= nc < m and graph[nr][nc] == 1: # 범위 내에 있으며, 이동할 수 있는 길일 경우
                tmp = graph[nr][nc] + ind[r][c]
                if tmp < ind[nr][nc]: # 최솟값 갱신
                    ind[nr][nc] = tmp
                    queue.append((nr,nc))
                
    return ind[n-1][m-1]

if __name__ == "__main__":
    n,m = map(int,input().split())
    graph = [list(map(int,input().rstrip())) for _ in range(n)]
    print(bfs())