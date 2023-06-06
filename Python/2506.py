s = 0
r = 0
n = int(input())
a = list(map(int,input().split()))
for i in range(n):
    if a[i] == 1:
        s += 1
        r += s
    else:
        s = 0
        
print(r)