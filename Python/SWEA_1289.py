t = int(input())
for tc in range(1, t+1):
    bit = input()
    cur = '0'

    cnt = 0
    for b in bit:
        if b != cur:
            cnt += 1
            cur = b
    print(f'#{tc} {cnt}')