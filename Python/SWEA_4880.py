# 1은 가위, 2는 바위, 3은 보
def win(a,b,arr):
    if arr[a] == arr[b]:
        return a
    elif (arr[a] == 1 and arr[b] == 3) or (arr[a] == 2 and arr[b] == 1) or (arr[a] == 3 and arr[b] == 2):
        return a
    else:
        return b
    
def game(start, end, arr):
    if start == end:
        return start
    
    mid = (start + end) // 2
    a = game(start, mid, arr)
    b = game(mid+1, end, arr)
    return win(a, b, arr)

t = int(input())
for tc in range(1, t+1):
    n = int(input())
    arr = list(map(int,input().split()))
    winner = game(0,n-1,arr)
    print(f'#{tc} {winner + 1}')