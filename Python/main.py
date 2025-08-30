for tc in range(1, int(input())+1):
    n = int(input())
    m = int(input())
    graph = [[0] * (n + 1) for _ in range(n + 1)]
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a][b] = 1

    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                if graph[i][k] and graph[k][j]:
                    graph[i][j] = 1
    
    answer = 0
    for i in range(1, n+1):
        tall = 0
        small = 0
        for j in range(1, n+1):
            if graph[i][j]:
                tall += 1
            elif graph[j][i]:
                small += 1
        if tall + small == n-1:
            answer += 1
    
    print(f'#{tc} {answer}')