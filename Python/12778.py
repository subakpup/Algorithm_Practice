for _ in range(int(input())):
    m,n = map(str,input().split())
    if n == 'C':
        word = list(map(str,input().split()))
        for i in range(len(word)):
            word[i] = ord(word[i]) - 64
    elif n == 'N':
        word = list(map(int,input().split()))
        for i in range(len(word)):
            word[i] = chr(word[i] + 64)
    print(*word)