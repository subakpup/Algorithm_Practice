from collections import deque
for tc in range(1, 11):
    _ = int(input())
    arr = deque(map(int, input().split()))

    while True:
        for i in range(1, 6):
            arr.append(arr.popleft()-i)
            if arr[-1] < 1:
                arr[-1] = 0
                break
        if arr[-1] == 0:
            break

    print(f'#{tc}', end=' ')
    print(*arr)