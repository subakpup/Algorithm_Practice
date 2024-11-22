def func(n):
    tmp = 0
    for i in range(1,n+1):
        if i % 2 == 0:
            tmp -= i
        else:
            tmp += i
    return tmp

t = int(input())
for tc in range(1,t+1):
    n = int(input())
    print(f"#{tc} {func(n)}")