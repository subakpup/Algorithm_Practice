"""Main_3109 빵집 (골드 2)
 - 메모리: 112340KB
 - 시간:2796ms

# 문제 정리
 - 가스관과 빵집을 연결하는 파이프라인의 최댓값
 - 모든 파이프 라인은 첫째 열에서 시작, 마지막 열에서 끝
 - 각 칸은 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결 가능
 - 경로는 겹칠 수 없고 서로 접할 수도 없다.

# 아이디어
 - DFS를 이용하여 이동할 수 있는 경로로 모두 탐색
 - 첫째 열에서 모든 행에서 시작
 - 마지막 열에 도달한다면 return
"""
import sys
input = sys.stdin.readline

# 이동 경로
dr = [-1, 0, 1]
dc = [1, 1, 1]

# 파이프라인 탐색
def dfs(r, c):
    # 방문 처리
    visited[r][c] = True 
    
    # 마지막 열에 도달한다면 return
    if c == C - 1:
        return True

    # 이동할 수 있는 3방향 탐색
    for i in range(3):
        nr = r + dr[i]
        nc = c + dc[i]
        # 범위 내 && 방문하지 않고 이동할 수 있는 경로라면 탐색 시작
        if 0 <= nr < R and 0 <= nc < C and not visited[nr][nc] and graph[nr][nc] == ".":
            # 다음 경로 탐색
            if dfs(nr, nc):
                return True
    # 이을 수 있는 경로가 없다면 False
    return False


if __name__ == "__main__":
    R, C = map(int,input().split())
    graph = [list(input()) for _ in range(R)]
    visited = [[False] * C for _ in range(R)]
    
    answer = 0
    # 모든 행에서 탐색 시작
    for i in range(R):
        if dfs(i, 0):
            answer += 1
    print(answer)
