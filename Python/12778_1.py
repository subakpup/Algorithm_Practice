# 숏코딩 버전
for _ in range(int(input())):
    m, n = input().split()
    word = input().split()
    word = [ord(c)-64 if n == 'C' else chr(int(c)+64) for c in word]
    print(*word)