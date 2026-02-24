t = int(input())
for test_case in range(1,t+1):
    n = int(input())
    arr = sorted(map(int,input().split()))
    print(f'#{test_case}', end=' ')
    print(*arr)