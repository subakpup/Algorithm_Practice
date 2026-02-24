for tc in range(1, 11):
    n, pwd = input().split()
    pwd = list(pwd)

    i = 0
    while i < len(pwd)-1:
        if pwd[i] == pwd[i+1]:
            del pwd[i:i+2]
            i = 0
        else:
            i += 1

    print(f'#{tc} ', *pwd, sep='')
