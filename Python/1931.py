import sys
input = sys.stdin.readline

arr = []
n = int(input())
for _ in range(n):
    start,end = map(int,input().split())
    arr.append([start,end])
arr.sort(key=lambda x:(x[1],x[0]))

cnt = 1
end = arr[0][1]
for i in range(1,n):
    if arr[i][0] >= end:
        end = arr[i][1]
        cnt += 1
print(cnt)