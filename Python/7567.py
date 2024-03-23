import sys
input = sys.stdin.readline

a = list(input().rstrip())
cnt = 0
for i in range(len(a)):
    if i == 0:
        cnt += 10
    elif a[i] == a[i-1]:
        cnt += 5
    else:
        cnt += 10
print(cnt)