t = int(input())
for tc in range(1,t+1):
    n = int(input())
    s = 0
    res = 0
    for i in range(n):
        arr = list(map(int,input().split()))
        if arr[0] == 1:
            s += arr[1]
        elif arr[0] == 2:
            if arr[1] < s:
                s -= arr[1]
            else:
                s = 0
        res += s
    print(f'#{tc} {res}')