err = 'abcdefghijklmnopqrstuvwxyz'
s = input()
cnt = 1

for i in range(len(s)-1):
    if err.index(s[i]) < err.index(s[i+1]):
        continue
    else:
        cnt += 1
print(cnt)