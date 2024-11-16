for tc in range(1, 11):
    n = int(input())
    arr = list(map(int,input().split()))
    m = int(input())
    cmd = input().split()

    for i in range(len(cmd)):
        if cmd[i] == 'I':
            idx = int(cmd[i + 1])
            rng = int(cmd[i + 2])
            val = list(map(int, cmd[i+3:i+3+rng]))
            arr[idx:idx] = val

        elif cmd[i] == 'D':
            idx = int(cmd[i + 1])
            rng = int(cmd[i + 2])
            del arr[idx:idx+rng]

        elif cmd[i] == 'A':
            rng = int(cmd[i + 1])
            val = list(map(int, cmd[i+2:i+2+rng]))
            arr.append(val)

    print(f'#{tc} ', end='')
    print(*arr[:10])