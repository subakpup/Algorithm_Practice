for tc in range(1, 11):
    n = int(input())
    arr = list(map(int, input().split()))
    m = int(input())
    cmd = input().split('I')[1:]

    for i in cmd:
        cmd_lst = list(map(int, i.split()))
        idx = cmd_lst[0]
        val = cmd_lst[2:]

        arr[idx:idx] = val

    print(f'#{tc} ', end='')
    print(*arr[0:10])