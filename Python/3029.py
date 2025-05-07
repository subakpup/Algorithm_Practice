h1,m1,s1 = map(int,input().split(':'))
h2,m2,s2 = map(int,input().split(':'))
t1 = h1 * 3600 + m1 * 60 + s1
t2 = h2 * 3600 + m2 * 60 + s2
time = t2 - t1 if t2 - t1 > 0 else t2 - t1 + 24 * 60 * 60

h = time // 3600
m = time // 60 % 60
s = time % 60
print(f'{h:02d}:{m:02d}:{s:02d}')