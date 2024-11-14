for tc in range(1,11):
    _ = int(input())
    s = input()
    line = input()

    res = line.count(s)
    print(f'#{tc} {res}')