import sys
input = sys.stdin.readline

paper = int(input())
arr = []

for i in range(100):
    tmp = []
    for i in range(100):
        tmp.append(0)
    arr.append(tmp)

for _ in range(paper):
    n,m = map(int,input().split())
    for i in range(n,n+10):
        for j in range(m,m+10):
            arr[i][j] = 1

area = 0
for i in arr:
    area += i.count(1)
    
print(area)