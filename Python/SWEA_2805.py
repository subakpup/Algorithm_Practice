t = int(input())
for tc in range(1, t+1):
    n = int(input())
    arr = [list(map(int,input())) for _ in range(n)]

    answer = 0
    for i in range(n):
        v = abs(n//2 - i)
        answer += sum(arr[i][v:n-v])

    print(f'#{tc} {answer}')