t = int(input())
days = [31,28,31,30,31,30,31,31,30,31,30,31]
for test_case in range(1, t+1):
    m1,d1,m2,d2 = map(int,input().split())
    res = 0
    if m1 == m2:
        res = d2 - d1 + 1
    else:
        res += sum(days[m1:m2-1]) + d2 + (days[m1-1] - d1 + 1)

    print(f'#{test_case} {res}')