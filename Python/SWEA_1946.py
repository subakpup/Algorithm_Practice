t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    string = ''
    res = []
    
    for _ in range(n):
        a,b = input().split()
        string += a * int(b)
    
    while string:
        res.append(string[:10])
        string = string[10:]

    print(f'#{test_case}')
    for i in res:
        print(i)