for i in range(int(input())):
    n = list(map(int,input().split()))
    nsum = sum(n[1:4])
    if nsum < 55:
        print(n[0], nsum, 'FAIL')
    elif n[1]/35 < 0.3:
        print(n[0], nsum, 'FAIL')
    elif n[2]/25 < 0.3:
        print(n[0], nsum, 'FAIL')
    elif n[3]/40 < 0.3:
        print(n[0], nsum, 'FAIL')
    elif n[1]/35 >= 0.3 and n[2]/25 >= 0.3 and n[3]/40 >= 0.3:
        print(n[0], nsum, 'PASS')