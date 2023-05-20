n,m,k = map(int,input().split())
maxo = min(m,k)
maxx = min(n-m,n-k)
print(maxo+maxx)