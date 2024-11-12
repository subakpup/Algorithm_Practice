t = int(input())
for tc in range(1,t+1):
    n = int(input())
    arr = list(map(int,input().split()))
    dic = {}

    for i in arr:
        if i in dic:
            dic[i] += 1
        else:
            dic[i] = 1

    res = max(dic, key=dic.get)
    print(f'#{tc} {res}')