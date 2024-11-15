t = int(input())
for test_case in range(1, t+1):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    res = 0

    if n > m:
        for i in range(n-m+1):
            ans = []
            for j in range(m):
                ans.append(a[i+j] * b[j])
            res = max(res, sum(ans))
    else:
        for i in range(m-n+1):
            ans = []
            for j in range(n):
                ans.append(a[j] * b[i+j])
            res = max(res, sum(ans))

    print(f'#{test_case} {res}')
