star = int(input())

for i in range(1, star):
    print(' ' * (star-i) + '*'*(2*i-1))

for i in range(star, 0, -1):
    print(' '*(star-i) + '*'*(2*i-1))