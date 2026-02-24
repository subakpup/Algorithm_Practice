money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
t = int(input())

for tc in range(1,t+1):
    n = int(input())
    res = [0] * 8
    for i in range(8):
        res[i] += n // money[i]
        n %= money[i]
    print(f'#{tc}')
    print(*res)