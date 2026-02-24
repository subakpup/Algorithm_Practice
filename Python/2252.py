"""Main_2252 줄 세우기 (골드 3)
    - 메모리: 
    - 시간: 

# 문제 정리
    - N명의 학생 키 순서로 줄 세우기
    - 일부 학생의 키를 비교해서 줄을 세워라

# 아이디어
    - 위상정렬
"""
from collections import deque
import sys
input = sys.stdin.readline

def func(arr):
    out = arr
    queue = deque(arr)
    
    while queue:
        node = queue.popleft()
        out.append(v)
        for v in graph[node]:
            ind[v] -= 1
            if ind[v] == 0:
                queue.append(v)  
    
    return out

if __name__ == "__main__":
    n, m = map(int, input().split())
    ind = [0] * (n+1)
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        ind[b] += 1
    
    arr = []
    for i in range(1, n+1):
        if ind[i] == 0:
            arr.append(i)

    print(*func(arr))