t = int(input())
for tc in range(1,t+1):
    n = int(input())
    arr = list(map(lambda x: abs(int(x)),input().split()))
    val = min(arr)
    cnt = arr.count(val)
    print(f'#{tc} {val} {cnt}')