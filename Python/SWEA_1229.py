for tc in range(1, 11):
    n = int(input())
    arr = list(map(int, input().split()))
    m = int(input())
    cmd = input().split()

    for i in range(len(cmd)):
        if cmd[i] == 'I':
            idx = int(cmd[i+1])
            rep = int(cmd[i+2])
            cmd_lst = list(map(int, cmd[i+3:i+3+rep]))

            arr[idx:idx] = cmd_lst
        elif cmd[i] == 'D':
            idx = int(cmd[i+1])
            rep = int(cmd[i+2])

            del arr[idx:idx+rep]

    print(f'#{tc} ', end='')
    print(*arr[:10])