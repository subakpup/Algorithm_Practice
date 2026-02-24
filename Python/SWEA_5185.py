t = int(input())
for tc in range(1, t+1):
    n,s = input().split()
    arr = [int(i,16) for i in s]
    answer = [bin(a)[2:].zfill(4) for a in arr]

    print(f'#{tc} {"".join(answer)}')