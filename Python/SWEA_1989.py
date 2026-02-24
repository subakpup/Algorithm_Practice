def func(s):
    if s == s[::-1]:
        return 1
    else:
        return 0

t = int(input())
for tc in range(1,t+1):
    s = input()
    res = func(s)
    print(f'#{tc} {res}')