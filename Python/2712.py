for i in range(int(input())):
    a,b = map(str,input().split())
    a = float(a)
    if b == 'kg':
        a *= 2.2046
        print(f'{a:.4f} lb')
    elif b == 'lb':
        a *= 0.4536
        print(f'{a:.4f} kg')
    elif b == 'l':
        a *= 0.2642
        print(f'{a:.4f} g')
    elif b == 'g':
        a *= 3.7854
        print(f'{a:.4f} l')