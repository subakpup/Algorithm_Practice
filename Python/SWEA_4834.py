from collections import defaultdict

t = int(input())
for tc in range(1, t+1):
    n = int(input())
    card = list(map(int,input()))
    dic = dict()

    for i in card:
        dic[i] = dic.get(i,0) + 1

    dic = sorted(dic.items(),key=lambda x: (x[1], x[0]), reverse=True)

    print(f'#{tc} {dic[0][0]} {dic[0][1]}')