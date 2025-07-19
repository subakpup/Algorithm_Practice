def func(arr):
    return list(zip(*arr[::-1]))

for tc in range(1, int(input())+1):
    n = int(input())
    board = [list(map(int,input().split())) for _ in range(n)]
    
    board90 = func(board)
    board180 = func(board90)
    board270 = func(board180)
    
    print(f'#{tc}')
    for i in range(n):
        print(*board90[i], sep='', end=' ')
        print(*board180[i], sep='', end=' ')
        print(*board270[i], sep='', end=' ')
        print()