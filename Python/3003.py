chess = [1,1,2,2,2,8]
s = list(map(int,input().split()))
for i in range(len(chess)):
    print(chess[i] - s[i], end= ' ')