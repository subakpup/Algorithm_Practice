"""Main_17471 게리맨더링 (골드 3)
    - 메모리: 34992KB
    - 시간: 64ms

# 문제 정리
    - 백준시는 n개의 구역으로 나누어짐 (1~n)
    - 구역을 2개의 선거구로 나누려 함
    - 각 구역은 두 선거구 중 하나에 포함
    - 선거구는 구역을 적어도 하나 포함
    - 한 선거구에 포함된 구역은 모두 연결 상태
    - 공평하기 위해 두 선거구의 인구 차이를 최소로 하려 함
    * 인구 차이의 최솟값을 출력!

# 아이디어
    - N의 크기가 최대 10이므로 모든 조합을 구할 수 있겠다!
    - 백트래킹을 이용해서 조합을 고르자
    - 조합을 구했을 때 각 구역들이 이어져있는지 탐색
"""

from collections import deque
import sys
input = sys.stdin.readline

def dfs(idx):
    global answer

    if idx == n + 1: # 모든 구역이 배치됐다면
        if connected(groupA) and connected(groupB): # 각 구역이 연결되었는지 확인
            sumA = sum(info[i] for i in groupA) # A 선거구의 총 인원수
            sumB = total - sumA # B 선거구의 총 인원수
            answer = min(answer, abs(sumA - sumB)) # 최솟값 갱신
        return

    groupA.append(idx) # 선거구 A에 idx번 구역 배치
    dfs(idx + 1) # 다음 구역 재귀
    groupA.pop() # 백트래킹

    groupB.append(idx)
    dfs(idx + 1)
    groupB.pop()

def connected(group):
    if not group: # group에 아무것도 없다면 False
        return False
    
    # BFS 이용
    queue = deque([group[0]]) # queue에 임의로 시작할 구역 추가
    visited = [group[0]] # 방문 표시

    while queue:
        cur = queue.popleft()
        for nxt in graph[cur]: # 현재 구역과 연결된 구역 탐색
            if nxt in group and not nxt in visited: # 연결된 구역이 선거구에 포함되어 있고, 방문하지 않았다면
                visited.append(nxt) # 방문 처리
                queue.append(nxt) # 큐에 추가
    
    return len(group) == len(visited) # 현재 선거구의 길이와 방문 처리한 구역의 길이가 같다면 True

if __name__ == "__main__":
    n = int(input()) # 구역수
    info = [0] + list(map(int, input().split())) # 각 구역의 인구수
    graph = [[] for _ in range(n+1)] # 인접 리스트
    for i in range(1, n+1):
        li = list(map(int, input().split()))
        for j in range(1, li[0]+1):
            graph[i].append(li[j]) # i번 구역과 연결된 지역들

    answer = int(1e9)
    total = sum(info) # 총 인구수
    groupA, groupB = [], [] # 2개의 그룹
    dfs(1) # 1번 구역부터 배치

    print(-1 if answer == int(1e9) else answer)
