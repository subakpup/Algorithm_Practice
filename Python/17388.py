s,k,h = map(int,input().split())
a = {s:'Soongsil', k:'Korea', h:'Hanyang'}
if sum(a) >= 100:
    print('OK')
else:
    print(a[min(a)])