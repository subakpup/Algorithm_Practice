t = int(input())
for test_case in range(1,t+1):
    n = int(input())
    rng = [2,3,5,7,11]
    res = [0,0,0,0,0]
    for i in range(5):
        while n % rng[i] == 0:
            res[i] += 1
            n //= rng[i]

    print(f'#{test_case}',end=' ')
    print(*res)