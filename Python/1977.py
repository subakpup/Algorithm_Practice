import sys
input = sys.stdin.readline

arr = []
m = int(input())
n = int(input())

for i in range(m, n+1):
    t = int(i**0.5) ** 2
    if i == t:
        arr.append(i)

if not arr:
    print(-1)
else:
    print(sum(arr))
    print(min(arr))