t = int(input())
for test_case in range(1,t+1):
    n = input()
    n = int(n[:-1] + '0')
    money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
    res = [0] * 8
    for i in range(8):
        if n // money[i] > 0:
            res[i] += n // money[i]
            n %= money[i]
    print(f'#{test_case}')
    print(*res)