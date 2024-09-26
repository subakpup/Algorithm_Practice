import sys
input = sys.stdin.readline

n,m = map(int,input().split())
board = [input() for _ in range(n)]
cnt = []

for k in range(n-7):
    for l in range(m-7):
        w,b = 0,0
        for i in range(k, k+8):
            for j in range(l, l+8):
                if (i+j) % 2 == 0:
                    if board[i][j] != 'W':
                        w += 1
                    else:
                        b += 1
                else:
                    if board[i][j] != 'B':
                        w += 1
                    else:
                        b += 1
        cnt.append(w); cnt.append(b)
print(min(cnt))