t = int(input())
for tc in range(1, t+1):
    n = int(input())
    stair = list(map(int,input().split()))

    a,b = 0,0
    for i in range(n-1):
        tmp = stair[i+1] - stair[i]
        if tmp > 0:
            a = max(a, tmp)
        else:
            b = abs(min(-b, tmp))

    print(f'#{tc} {a} {b}')