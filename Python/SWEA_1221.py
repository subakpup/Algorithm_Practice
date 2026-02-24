t = int(input())
for tc in range(1, t+1):
    num = {"ZRO":0, "ONE":0, "TWO":0, "THR":0, "FOR":0, "FIV":0, "SIX":0, "SVN":0, "EGT":0, "NIN":0}
    a,b = input().split()
    num_lst = list(input().split())
    for i in num_lst:
        num[i] += 1

    print(f'#{tc}')
    for i in num:
        for _ in range(num[i]):
            print(i, end=' ')