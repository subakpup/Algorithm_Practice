import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n = int(input())
    arr = {}
    for i in range(n):
        wear = list(input().split())
        if wear[1] in arr:
            arr[wear[1]].append(wear[0])
        else:
            arr[wear[1]] = [wear[0]]
    cnt = 1
    
    for j in arr:
        cnt *= (len(arr[j])+1)
    print(cnt-1)