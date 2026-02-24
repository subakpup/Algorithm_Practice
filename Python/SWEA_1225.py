from collections import deque

t = 10
for tc in range(1, t+1):
    n = int(input())
    arr = deque(map(int,input().split()))

    while True:
        for i in range(1, 6):
            arr.append(arr.popleft() - i)
            if arr[-1] <= 0:
                arr[-1] = 0
                break
        if arr[-1] == 0:
            break

    print(f'#{tc}', end=' ')
    print(*arr)