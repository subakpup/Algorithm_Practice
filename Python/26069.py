import sys
input = sys.stdin.readline

arr = {'ChongChong'}
for i in range(int(input())):
    a,b = input().split()
    if a in arr:
        arr.add(b)
    if b in arr:
        arr.add(a)
        
print(len(arr))