import sys
input = sys.stdin.readline

a = list(input().rstrip())
b = input().split()

for i in range(len(a)):
    for j in b:
        if a[i].upper() == j:
            a[i] = a[i].lower()

print(*a, sep='')