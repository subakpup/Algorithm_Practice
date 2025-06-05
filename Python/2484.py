import sys
input = sys.stdin.readline

n = int(input())
answer = 0
for _ in range(n):
    dice = list(map(int,input().split()))
    dic = dict()
    
    for d in dice:
        dic[d] = dic.get(d,0) + 1

    dic = sorted(dic.items(), key=lambda x: (x[1], x[0]), reverse=True)

    reward = 0
    if len(dic) == 1:
        reward = 50000 + dic[0][0] * 5000
    elif len(dic) == 2:
        if dic[0][1] == 3:
            reward = 10000 + dic[0][0] * 1000
        else:
            reward = 2000 + dic[0][0] * 500 + dic[1][0] * 500
    elif len(dic) == 3:
        reward = 1000 + dic[0][0] * 100
    else:
        reward = dic[0][0] * 100
    
    answer = max(answer, reward)
    
print(answer)