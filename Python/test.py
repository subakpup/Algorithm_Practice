import sys
input = sys.stdin.readline

cnt = int(input())
for _ in range(cnt):
    a = input()
    for i in range(len(a)-1):
        if a[i] == a[i+1]:
            pass
        elif a[i] in a[i+1:]:
            cnt -= 1

print(cnt)