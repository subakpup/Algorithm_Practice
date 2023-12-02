import sys
input = sys.stdin.readline

a = []
for i in range(int(input())):
    [x,y] = map(int,input().split())
    a.append([x,y])
a.sort()
for j in a:
    print(j[0], j[1])