import sys
input = sys.stdin.readline

arr = []

for i in range(int(input())):
    x,y = map(int,input().split())
    arr.append((x,y))

for i in arr:
    res = 1
    for j in arr:
        if i[0] < j[0] and i[1] < j[1]:
            res += 1
    print(res, end=' ')