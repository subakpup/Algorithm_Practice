dx = [-1,1,0,0,-1,-1,1,1]
dy = [0,0,-1,1,-1,1,-1,1]
t = int(input())
for tc in range(1,t+1):
    n,m = map(int,input().split())
    board = [[0] * n for _ in range(n)]
    # 흑 == 1, 백 == 2
    if n == 4:
        board[1][2] = board[2][1] = 1
        board[1][1] = board[2][2] = 2
    elif n == 6:
        board[2][3] = board[3][2] = 1
        board[2][2] = board[3][3] = 2
    elif n == 8:
        board[3][4] = board[4][3] = 1
        board[3][3] = board[4][4] = 2

    for _ in range(m):
        x,y,c = map(int,input().split())
        board[x-1][y-1] = c
        for i,j in (dx,dy):
            r = []

    bcnt = wcnt = 0
    for lst in board:
        bcnt += lst.count(1)
        wcnt += lst.count(2)