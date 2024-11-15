def func(s):
    cnt = 0
    for i in range(len(s)):
        for j in range(i+2, len(s)+1):
            substring = s[i:j]
            if substring == substring[::-1]:
                if cnt < len(substring):
                    cnt = len(substring)
    return cnt

for _ in range(10):
    tc = int(input())
    arr = [input() for _ in range(100)]
    res = 0

    for i in range(100):
        if res < func(arr[i]):
            res = func(arr[i])
    
    arr2 = [list(j) for j in zip(*arr)]
    for k in range(100):
        if res < func(arr2[k]):
            res = func(arr2[k])

    print(f'#{tc} {res}')