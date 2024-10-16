import sys
input = sys.stdin.readline

arr = {'ChongChong'}
for i in range(int(input())):
    a,b = input().split()
    if a in arr or b in arr:
        arr.add(a); arr.add(b)
print(len(arr))