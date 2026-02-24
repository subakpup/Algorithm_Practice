s = input()
cnt = 10
for i in range(1, len(s)):
    if s[i-1] == s[i]:
        cnt += 5
    else:
        cnt += 10
print(cnt)