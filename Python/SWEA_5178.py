t = int(input())
for tc in range(1, t+1):
    n,m = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    answer = n + m - len(set(a + b))

    print(f'#{tc} {answer}')