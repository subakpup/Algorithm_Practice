def plus_spray(x,y):
    d = [(-1,0), (0,-1), (1,0), (0,1)]
    total = board[x][y]
    for dx,dy in d:
        for i in range(1, m):
            nx,ny = x + dx * i, y + dy * i
            if 0 <= nx < n and 0 <= ny < n:
                total += board[nx][ny]
    return total

def x_spray(x,y):
    d = [(-1,-1), (-1,1), (1,-1), (1,1)]
    total = board[x][y]
    
    for dx,dy in d:
        for i in range(1,m):
            nx,ny = x + dx * i, y + dy * i
            if 0 <= nx < n and 0 <= ny < n:
                total += board[nx][ny]
    return total

for tc in range(1, int(input())+1):
    n,m = map(int,input().split())
    board = [list(map(int,input().split())) for _ in range(n)]
    
    answer = 0
    for i in range(n):
        for j in range(n):
            answer = max(answer, plus_spray(i,j), x_spray(i,j))
    
    print(f'#{tc} {answer}')