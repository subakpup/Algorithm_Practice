t = int(input())
for tc in range(1, t+1):
    n,m,l = map(int,input().split())
    arr = list(map(int,input().split()))

    for i in range(m):
        a,b = map(int,input().split())
        arr.insert(a,b)

    print(f'#{tc} {arr[l]}')