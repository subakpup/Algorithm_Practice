t = int(input())
for tc in range(1,t+1):
    arr = list(map(int,input().split()))
    arr.remove(min(arr))
    arr.remove(max(arr))
    res = round(sum(arr) / 8)
    print(f'#{tc} {res}')