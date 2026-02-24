""" Solution_5643 키 순서 (D4)
# 문제 정리
 - 키가 모두 다른 N명의 학생
 - 두 학생끼리 키를 비교한 결과의 일부가 주어짐
 - 자신의 키가 몇 번째인지 알 수 있는 학생들이 모두 몇 명인지 계산하여 출력

# 아이디어
 - 플로이드 워셜 알고리즘을 활용하면 쉽게 구할 수 있다
 - 단방향 그래프를 그린 후, i -> k와 k -> j의 관계를 파악할 수 있으면 i -> j 간선을 추가로 그려준다.
"""

for tc in range(1, int(input())+1):
    n = int(input()) # 학생 수
    m = int(input()) # 키를 비교한 횟수

    graph = [[0] * (n+1) for _ in range(n+1)] # 관계를 담을 그래프
    for i in range(m):
        a,b = map(int,input().split())
        graph[a][b] = 1 # a -> b 간선

    # 모든 정점 쌍 관계 계산
    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                if graph[i][k] and graph[k][j]: # i -> k && k -> j
                    graph[i][j] = 1 # i -> j 간선 연결

    answer = 0
    for i in range(1, n+1):
        small = 0
        tall = 0
        for j in range(1, n+1):
            if graph[i][j]: # 자신보다 큰 사람이 있다면
                tall += 1 # tall 증가
            if graph[j][i]: # 자신보다 작은 사람이 있다면
                small += 1 # small 증가
        
        if small + tall == n-1: # 작은 사람과 큰 사람의 합이 전체 학생 수와 일치한다면
            answer += 1 # 정답 + 1

    print(f"#{tc} {answer}")