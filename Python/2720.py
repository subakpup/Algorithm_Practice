import sys
input = sys.stdin.readline

changes = [25, 10, 5, 1]

for i in range(int(input())):
    c = int(input())
    arr = []
    for j in changes:
        arr.append(c//j)
        c = c%j
    print(*arr)