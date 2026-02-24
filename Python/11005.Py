num = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
n,m = map(int,input().split())
res = ''
while n > 0:
    res += num[n%m]
    n //= m
print(''.join(reversed(res)))