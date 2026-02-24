"""Solution_1873 상호의 배틀필드 (D3)
# 문제 정리
 - 맵 구성
    .: 평지
    *: 벽돌 벽
    #: 강철 벽
    -: 물
    ^, v, <, >: 전차(위, 아래, 왼쪽, 오른쪽)

 - 커맨드
    U: 위로 이동
    D: 아래로 이동
    L: 왼쪽으로 이동
    R: 오른쪽으로 이동
    S: 발사
 
 - 전차는 항상 범위 내
 - 물로 이동 불가
 - 포탄 발사: 벽에 충돌 or 맵 밖으로 나갈 때까지 직진
 - 벽에 충돌 시
  - 벽돌 벽: 파괴
  - 강철 벽: 파괴 불가
"""

for tc in range(1, int(input()) + 1):
    h, w = map(int, input().split())
    field = [list(input()) for _ in range(h)]

    n = int(input())
    command = input()
    direction = ''

    # 전차 위치 찾기
    r, c = -1, -1
    for i in range(h):
        for j in range(w):
            if field[i][j] in '^v<>':
                r, c = i, j
                direction = field[i][j]
                break
        if direction:
            break

    # 커맨드 처리
    for cmd in command:
        if cmd == 'U':
            if 0 < r and field[r - 1][c] == '.':
                field[r][c] = '.'
                r -= 1
                field[r][c] = '^'
                direction = '^'
            else:
                field[r][c] = '^'
                direction = '^'
        elif cmd == 'D':
            if r < h - 1 and field[r + 1][c] == '.':
                field[r][c] = '.'
                r += 1
                field[r][c] = 'v'
                direction = 'v'
            else:
                field[r][c] = 'v'
                direction = 'v'
        elif cmd == 'L':
            if 0 < c and field[r][c - 1] == '.':
                field[r][c] = '.'
                c -= 1
                field[r][c] = '<'
                direction = '<'
            else:
                field[r][c] = '<'
                direction = '<'
        elif cmd == 'R':
            if c < w - 1 and field[r][c + 1] == '.':
                field[r][c] = '.'
                c += 1
                field[r][c] = '>'
                direction = '>'
            else:
                field[r][c] = '>'
                direction = '>'
        elif cmd == 'S':
            if direction == '^':
                for i in range(r, -1, -1):
                    if field[i][c] == '*':
                        field[i][c] = '.'
                        break
                    elif field[i][c] == '#':
                        break
            elif direction == '>':
                for i in range(c, w):
                    if field[r][i] == '*':
                        field[r][i] = '.'
                        break
                    elif field[r][i] == '#':
                        break
            elif direction == '<':
                for i in range(c, -1, -1):
                    if field[r][i] == '*':
                        field[r][i] = '.'
                        break
                    elif field[r][i] == '#':
                        break
            elif direction == 'v':
                for i in range(r, h):
                    if field[i][c] == '*':
                        field[i][c] = '.'
                        break
                    elif field[i][c] == '#':
                        break
    
    print(f'#{tc}', end=" ")
    for row in field:
        print(*row, sep="")
