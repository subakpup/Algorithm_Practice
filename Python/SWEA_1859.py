t = int(input())
for tc in range(1, t+1):
    n = int(input())
    total = list(map(int, input().split()))
    res = 0
    price = 0

    for i in total[::-1]:
        if i >= price:
            price = i
        else:
            res += price - i

    print(f'#{tc} {res}')