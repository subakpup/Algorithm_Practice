t = int(input())
for tc in range(1, t+1):
    n,m = map(int,input().split())
    arr = list(map(int,input().split()))
    cur = sum(arr[:m])
    min_val = max_val = cur
    
    for i in range(1, n-m+1):
        cur = cur - arr[i-1] + arr[i + m - 1]
        min_val = min(min_val, cur)
        max_val = max(max_val, cur)
    
    print(f'#{tc} {max_val - min_val}')