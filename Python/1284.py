while True:
    a = 1
    n = input()
    if n == '0':
        break
    for i in range(len(n)):
        if n[i] == '0':
            a += 4
        elif n[i] == '1':
            a += 2
        else:
            a += 3
    print(a+len(n))