import sys
input = sys.stdin.readline
arr = []
for i in range(int(input())):
    arr.append(int(input()))
arr.sort()
for j in arr:
    print(j)