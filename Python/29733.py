import sys
input = sys.stdin.readline

def func(board):
    res = [[[0] * c for _ in range(r)] for _ in range(h)]
    
    for z in range(h):
        for y in range(r):
            for x in range(c):
                if board[z][y][x] == '*':
                    res[z][y][x] = '*'
                else:
                    cnt = 0
                    for dz,dy,dx in directions:
                        nz = z + dz
                        ny = y + dy
                        nx = x + dx
                        if 0 <= nz < h and 0 <= ny < r and 0 <= nx < c:
                            if board[nz][ny][nx] == '*':
                                cnt += 1
                    res[z][y][x] = cnt % 10

    return res

def direction():
    d = []
    for dx in (-1,0,1):
        for dy in (-1,0,1):
            for dz in (-1,0,1):
                if dx == 0 and dy == 0 and dz == 0:
                    continue # 자기 자신 제외
                d.append((dx,dy,dz))
    return d

if __name__ == "__main__":
    r,c,h = map(int,input().split())
    board = [[list(input().rstrip()) for _ in range(r)] for _ in range(h)]
    directions = direction()
    
    answer = func(board)
    for i in range(h):
        for j in range(r):
            print(*answer[i][j], sep='')