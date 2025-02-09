cnt = {}

for i in range(int(input())):
    a,b = map(int,input().split())
    if a not in cnt:
        cnt[a] = b
    else:
        cnt[a] += b
    
print(cnt)