while True:
    a,b = input().split()
    
    if a == b == '0':
        break

    size = max(len(a),len(b)) - min(len(a),len(b))
    for _ in range(size):
        if len(a) > len(b):
            b = '0'+b
        elif len(a) < len(b):
            a = '0'+a
    
    cnt = carry = 0
    for i in range(len(a)-1, -1, -1):
        if int(a[i]) + int(b[i]) + carry > 9:
            carry = 1
            cnt += 1
        else:
            carry = 0

    print(cnt)