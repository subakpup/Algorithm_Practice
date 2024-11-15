def func(n,s):
    cnt = 0
    for i in range(len(s)-n+1):
        substr = s[i:i+n]
        if substr == substr[::-1]:
            cnt += 1
    return cnt


for tc in range(1,11):
    n = int(input())
    arr = [input() for _ in range(8)]
    cnt = 0

    for i in range(len(arr)):
        cnt += func(n,arr[i])
    
    arr2 = [list(j) for j in zip(*arr)]
    for k in range(len(arr2)):
        cnt += func(n,arr2[k])

    print(f'#{tc} {cnt}')