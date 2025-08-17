"""Main_2606 바이러스 (실버 3)
 - 메모리: 32412KB
 - 시간: 36ms

# 문제 정리
 - 한 컴퓨터가 바이러스에 감염되면
  => 연결된 모든 컴퓨터 감염
 - 1번 컴퓨터를 통해 바이러스에 걸리는 컴퓨터의 수 출력

# 아이디어
 - 연결된 컴퓨터를 모두 탐색하여 카운팅하면 되겠다 !
"""
import sys
input = sys.stdin.readline

def dfs(x):
    global answer
    visited[x] = True # 감염된 컴퓨터 처리
    for i in graph[x]: # 연결된 컴퓨터 탐색
        if not visited[i]: # 탐색을 하지 않은 노드라면
            dfs(i) # 탐색
            answer += 1 # 컴퓨터 수 + 1

if __name__ == "__main__":
    n = int(input()) # 컴퓨터 수(노드)
    m = int(input()) # 연결된 컴퓨터 쌍의 수(간선)

    visited = [False] * (n+1) # 탐색 여부
    answer = 0

    graph = [[] for _ in range(n+1)] # 연결된 쌍을 저장할 배열
    for i in range(m):
        a,b = map(int,input().split())
        # 양방향 연결
        graph[a].append(b)
        graph[b].append(a)
    
    dfs(1) # 1번 컴퓨터부터 시작
    print(answer)