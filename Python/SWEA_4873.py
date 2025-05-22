t = int(input())
for tc in range(1, t+1):
    s = list(input())

    while True:
        for i in range(len(s) - 1):
            if s[i] == s[i + 1]:
                del(s[i:i+2])
                break
        else:
            break

    print(f'#{tc} {len(s)}')