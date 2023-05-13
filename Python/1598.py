n,m = map(int,input().split())
n-=1; m-=1
print(abs(m//4-n//4) + abs(m%4-n%4))