t = int(input())
for tc in range(1, t+1):
    n,m = map(int,input().split())
    a = [input() for _ in range(n)]
    b = [input() for _ in range(m)]
    answer = len(a + b) - len(set(a + b))
    print(f'#{tc} {answer}')