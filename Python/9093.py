import sys
input = sys.stdin.readline

for i in range(int(input())):
    a = list(input().split())
    for j in a:
        print(j[::-1], end=' ')
    print()