x,y = map(int,input().split())
if x<y:
    print(-1)
else:
    a = (x+y)//2
    b = (x-y)//2
    if a+b == x and a-b == y:
        print(a,b)
    else:
        print(-1)