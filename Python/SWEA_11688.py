t = int(input())
for tc in range(1, t+1):
    n = input()
    node = [1, 1]

    for i in range(len(n)):
        if n[i] == 'L':
            node[0] = node[0]
            node[1] = node[0] + node[1]
        else:
            node[0] = node[0] + node[1]
            node[1] = node[1]

    print(f'#{tc} {node[0]} {node[1]}')