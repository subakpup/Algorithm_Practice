n = list(input())
arr = ['ABC','DEF','GHI','JKL','MNO','PQRS','TUV','WXYZ']
second = 0

for i in range(len(n)):
    for j in arr:
        if n[i] in j:
            second += arr.index(j) + 3

print(second)