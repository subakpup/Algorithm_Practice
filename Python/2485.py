import sys
input = sys.stdin.readline

a = []

for i in range(int(input())):
    a.append(int(input()))

if a[0] % 2:
    res = (a[0] + a[-1]) // 2
else:
    res = (a[0] + a[-1]) // 2 - 1

print(res - len(a))