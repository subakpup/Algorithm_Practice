t = int(input())
for tc in range(1, t+1):
    l,u,x = map(int,input().split())
    answer = 0
    if x < l:
        answer = l - x
    elif x > u:
        answer = -1
    print(f'#{tc} {answer}')