t = int(input())
for tc in range(1, t+1):
    n,m = map(int,input().split())
    arr = list(map(int,input().split()))
    
    answer = arr[m%n]
    print(f'#{tc} {answer}')