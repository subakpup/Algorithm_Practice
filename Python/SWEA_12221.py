t = int(input())
for tc in range(1, t+1):
    a,b = map(int,input().split())
    answer = -1
    if len(str(a)) < 2 and len(str(b)) < 2:
        answer = a*b
    print(f'#{tc} {answer}')