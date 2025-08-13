""" Solution_5650 핀볼 게임
# 문제 정리
 - N x N 크기의 게임판
 - 핀볼은 1개의 시작점에서 어느 방향으로든 출발 가능
 - 삼각형 1~4
 - 사각형 5
 - 웜홀(6~10)은 서로 연결되어 순간 이동
 - 블랙홀(-1) or 출발 지점에 닿으면 게임 종료
 - 벽 or 블럭에 부딪히면 점수 + 1
 * 핀볼이 출발한 위치에서 시작해서 최대 점수

# 아이디어
 - 전체 좌표를 돌며 0인 지점에서 4방향 모두 시작해보고 값을 업데이트하면 되겠다!
 - 종료 조건, 벽에 부딪힌 경우, 블록에 부딪힌 경우, 웜홀에 부딪힌 경우
 - 삼각형에 부딪힌 경우 방향 전환 설정을 미리 배열에 담아놔야겠다!
 - 벽을 사각형으로 감싸놓으면 편하지 않을까?
"""
# 4방향
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

# 방향 전환
changeDirection = [
    [0, 1, 2, 3],
    [1, 3, 0, 2],
    [1, 2, 3, 0],
    [2, 0, 3, 1],
    [3, 0, 1, 2],
    [1, 0, 3, 2]
]

# 웜홀 만난 경우
def wormhole(x, y, wormholeNum):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if ((x != i or y != j) and board[i][j] == wormholeNum):
                return i, j

def move(sx, sy, d):
    cnt = 0
    x, y = sx, sy

    while True:
        x += dx[d]
        y += dy[d]

        # 시작점 or 블랙홀
        if (x == sx and y == sy) or board[x][y] == -1:
            return cnt
        
        # 블록일 경우
        if 1 <= board[x][y] <= 5:
            d = changeDirection[board[x][y]][d]
            cnt += 1    
        # 웜홀일 경우
        elif 6 <= board[x][y] <= 10:
            x, y = wormhole(x, y, board[x][y])


if __name__ == "__main__":
    for tc in range(1, int(input())+1):
        n = int(input())

        # 게임판 생성
        board = [[5] * (n + 2) for _ in range(n+2)]
        for i in range(1, n+1):
            row = list(map(int,input().split()))
            for j in range(1, n+1):
                board[i][j] = row[j-1]

        # 시작 지점 전부 탐색
        answer = 0
        for i in range(1, n+1):
            for j in range(1, n+1):
                if board[i][j] != 0:
                    continue
                for d in range(4):
                    answer = max(move(i, j, d), answer)
        
        print(f"#{tc} {answer}")