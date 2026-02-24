import sys
input = sys.stdin.readline

arr = []

for i in range(1,6):
    name = input()
    if 'FBI' in name:
        arr.append(i)

if arr:
    print(*arr)
else:
    print('HE GOT AWAY!')