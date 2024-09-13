diagram = ['ABC','DEF','GHI','JKL','MNO','PQRS','TUV','WXYZ']

s = input()
second = 0

for i in range(len(s)):
    for j in diagram:
        if s[i] in j:
            second += diagram.index(j) + 3

print(second)