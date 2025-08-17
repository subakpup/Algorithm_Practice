from collections import deque
import sys
input = sys.stdin.readline

def dfs(idx):
    if idx == n:
        

    A.append(area[idx])
    dfs(idx+1)
    A.pop()

    B.append(area[idx])
    dfs(idx+1)
    B.pop()

def bfs():
    queue = deque([])



if __name__ == "__main__":
    n = int(input()) # 구역 수
    popul = [0] + list(map(int,input().split())) # 구역 별 인구수

    graph = [[] for _ in range(n+1)]
    for i in range(1, n+1):
        cmd = list(map(int,input().split()))
        for j in range(1, cmd[0]+1):
            graph[i].append(cmd[j])
    
    area = [i for i in range(1, n+1)]
    A, B = [], []
    dfs(1)
