t = int(input())
for tc in range(1,t+1):
    n = int(input())
    arr = list(range(0,10))
    cnt = 1
    while len(arr) != 0:
        m = n * cnt
        for i in str(m):
            if int(i) in arr:
                arr.remove(int(i))
        cnt += 1
    print(f'#{tc} {m}')