for i in range(int(input())):
    a  = input()
    t = int(input())
    r = 0
    for j in range(t):
        r += int(input())
    if r % t == 0:
        print('YES')
    else:
        print('NO')