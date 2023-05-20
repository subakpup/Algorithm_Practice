s = int(input())
n = list(map(int,input().split()))
y = 0
m = 0
for i in n:
    y += i//30*10+10
    m += i//60*15+15
if y>m:
    print('M', m)
elif y<m:
    print('Y', y)
elif y==m:
    print('Y M', y)