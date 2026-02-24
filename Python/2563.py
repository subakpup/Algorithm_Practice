import sys
input = sys.stdin.readline

arr = [[0 for _ in range(100)] for _ in range(100)]

for _ in range(int(input())):
    x,y = map(int,input().split())
    for i in range(x, x+10):
        for j in range(y, y+10):
            arr[i][j] = 1

print(sum(k.count(1) for k in arr))