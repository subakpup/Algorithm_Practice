t = int(input())
for tc in range(1, t+1):
    n = int(input())
    arr = list(map(int,input().split()))

    avg = sum(arr) // n
    cnt = sum(1 for i in arr if i <= avg)

    print(f'#{tc} {cnt}')