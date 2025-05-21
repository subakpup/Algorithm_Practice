import sys
input = sys.stdin.readline

a,b = map(int,input().split())
r = int(input())

arr = [[0] * r for _ in range(r)]
arr[a][b] = 1
cnt = 0

while True:
    if a+b+2 < r:
        a += 1; b += 1
        arr[a][b] += 1
    else:
        a //= 2; b //= 2
        arr[a][b] += 1
    
    cnt += 1
    
    if arr[a][b] >= 2:
        break
    
print(cnt)