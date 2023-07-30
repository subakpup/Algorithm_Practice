import sys
input = sys.stdin.readline

arr = []

for i in range(10):
    a = int(input())
    arr.append(a%42)

arr = set(arr)
print(len(arr))