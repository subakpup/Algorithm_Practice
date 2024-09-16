n,x = map(int,input().split())
res = -1

for i in range(n):
    s,t = map(int,input().split())
    if res < s and s+t <= x:
        res = s
        
print(res)