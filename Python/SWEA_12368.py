t = int(input())
for tc in range(1, t+1):
    a,b = map(int,input().split())
    answer = a + b if (a+b) < 24 else abs(24 - (a+b))
    print(f'#{tc} {answer}')