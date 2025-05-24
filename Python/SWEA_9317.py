t = int(input())
for tc in range(1, t+1):
    n = int(input())
    string = input()
    write = input()

    cnt = 0
    for i in range(n):
        if string[i] == write[i]:
            cnt += 1
    print(f'#{tc} {cnt}')