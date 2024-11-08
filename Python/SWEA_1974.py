t = int(input())
for test_case in range(1, t+1):
    arr = [list(map(int,input().split())) for _ in range(9)]
    res = 1

    for i in range(9):
        lst = [arr[i][j] for j in range(9)]
        lst.sort()
        for c in range(9):
            if lst[c] != c+1:
                res = 0
                break

    for i in range(9):
        lst = [arr[j][i] for j in range(9)]
        lst.sort()
        for c in range(9):
            if lst[c] != c+1:
                res = 0
                break

    if res == 1:
        for i in range(0,9,3):
            for j in range(0,9,3):
                lst33 = sorted(arr[x][y] for x in range(i,i+3) for y in range(j, j+3))
                for k in range(9):
                    if lst33[k] != k+1:
                        res = 0
                        break

    print(f'#{test_case} {res}')