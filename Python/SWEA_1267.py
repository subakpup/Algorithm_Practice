"""Solution_1267 작업 순서 (D6)
# 문제 정리
 - V개의 작업
  - 어떤 작업은 특정 작업이 끝나야 시작할 수 있음 => 선행 관계
 - 사이클 존재 X
 - 선행 관계가 끝난 후 작업을 할 수 있다고 할 때, 일을 끝낼 수 있는 작업 순서 출력

# 아이디어
 - 위상 정렬 문제
 - 간선을 연결해줄 때 가리키는 노드의 값을 1씩 증가시켜준다
 - 탐색 시 가리키는 노드가 없을 경우 결과 배열에 추가
"""
from collections import deque

def bfs():
    answer = [] # 리턴할 배열

    queue = deque()
    for i in range(1, v+1):
        if ind[i] == 0: # 본인을 가리키는 노드가 없을 경우 queue에 추가
            queue.append(i)

    while queue:
        node = queue.popleft() # 가장 앞 노드 추출
        answer.append(str(node)) # 선행 관계가 없으므로 결과 배열에 삽입
        for n in graph[node]: # 가리키는 노드 탐색
            ind[n] -= 1 # 선행 관계인 노드가 빠졌으므로 1 감소
            if ind[n] == 0: # 1 감소 후 선행 관계가 없다고 판별되면
                queue.append(n) # 결괏값에 추가
    
    return ' '.join(answer)

for tc in range(1, 11): # 테스트 케이스
    v, e = map(int,input().split()) # 노드, 정점의 개수
    arr = list(map(int,input().split())) # 간선 나열
    
    graph = [[] for _ in range(v+1)] # 한 줄로 입력된 간선들을 그래프에 2차원 형태로 저장
    ind = [0] * (v+1) # 가리키는 노드가 있는지 알 수 있는 배열
    for i in range(0, e * 2, 2):
        a = arr[i]
        b = arr[i+1]
        graph[a].append(b) # a -> b
        ind[b] += 1 # b를 가리키는 노드 수 + 1

    print(f'#{tc} {bfs()}')