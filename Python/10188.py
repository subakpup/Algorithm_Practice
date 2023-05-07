for _ in range(int(input())):
    arr = []
    x,y = map(int,input().split())
    for i in range(y):
        tmp = []
        for j in range(x):
            tmp.append('X')
        arr.append(tmp)
    
    for tmp in arr:
        print(*tmp,sep='')