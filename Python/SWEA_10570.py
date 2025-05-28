def palindrome(n,m):
    cnt = 0
    for i in range(n,m+1):
        if str(i) == str(i)[::-1]:
            sqrt = int(i ** 0.5)
            if sqrt ** 2 == i and str(int(sqrt)) == str(int(sqrt))[::-1]:
                cnt += 1
    return cnt

t = int(input())
for tc in range(1, t+1):
    a,b = map(int,input().split())
    print(f'#{tc} {palindrome(a,b)}')