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

# 숏코딩 버전
# for _ in range(int(input())):
#     m, n = input().split()
#     word = input().split()
#     word = [ord(c)-64 if n == 'C' else chr(int(c)+64) for c in word]
#     print(*word)