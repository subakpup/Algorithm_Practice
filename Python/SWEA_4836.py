t = int(input())
for tc in range(1, t+1):
    board = [[0] * 10 for _ in range(10)]

    for _ in range(int(input())):
        r1,c1,r2,c2,color = map(int,input().split())
        for i in range(r1, r2+1):
            for j in range(c1, c2+1):
                if color == 1:
                    board[i][j] |= 1
                else:
                    board[i][j] |= 2

    cnt = sum(board[i][j] == 3 for i in range(10) for j in range(10))

    print(f'#{tc} {cnt}')