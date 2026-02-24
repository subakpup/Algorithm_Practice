def palindrome(arr):
    for i in range(n):
        for j in range(0, n - m + 1):
            chk = arr[i][j:j+m]
            if chk == chk[::-1]:
                return chk
    return False

t = int(input())
for tc in range(1, t+1):
    n,m = map(int,input().split())
    arr = [input() for _ in range(n)]
    
    answer = palindrome(arr)
    if not answer:
        arr = list(map(list,zip(*arr)))
        answer = ''.join(palindrome(arr))

    print(f'#{tc} {answer}')