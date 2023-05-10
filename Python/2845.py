l,p = map(int,input().split())
people = list(map(int,input().split()))

for i in people:
    print(i - l*p,end=' ')