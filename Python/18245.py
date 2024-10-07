cnt = 2
while True:
    s = input()
    if s == 'Was it a cat I saw?':
        break
    print(s[::cnt])
    cnt += 1