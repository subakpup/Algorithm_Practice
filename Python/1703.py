while True:
    a = list(map(int,input().split()))
    if a[0] == 0:
        break
    l = 1
    for i in range(1, len(a), 2):
        l = l*a[i] - a[i+1]
    print(l)