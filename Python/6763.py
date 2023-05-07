sl = int(input())
ys = int(input())

if ys>sl:
    print('You are speeding and your fine is $', end='')
    if ys-sl > 30:
        print('500.')
    elif ys-sl > 20:
        print('270.')
    elif ys-sl > 1:
        print('100.')
else:
    print('Congratulations, you are within the speed limit!')        