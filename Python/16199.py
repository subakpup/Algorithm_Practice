y1,m1,d1 = map(int,input().split())
y2,m2,d2 = map(int,input().split())

if m1 < m2:
    mold = y2-y1
elif m2 == m1:
    if d1 > d2:
        mold = y2-y1-1
    else:
        mold = y2-y1
else:
    mold = y2-y1-1
print(mold)
print(y2-y1+1)
print(y2-y1)