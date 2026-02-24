while True:
    n = input().split()
    member = 'Junior'
    if int(n[1]) > 17 or int(n[2]) >= 80:
        member = 'Senior'
    if n[0] == '#':
        break
    print(n[0] +' '+ member)