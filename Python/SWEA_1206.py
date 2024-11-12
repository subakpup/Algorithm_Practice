for tc in range(1,11):
    n = int(input())
    arr = list(map(int,input().split()))
    res = 0
    for i in range(2, n-1):
        if arr[i] > arr[i-1] and arr[i] > arr[i-2] and arr[i] > arr[i+1] and arr[i+2]:
            h = max(arr[i-1], arr[i-2], arr[i+1], arr[i+2])
            res += arr[i] - h
    print(f'#{tc} {res}')