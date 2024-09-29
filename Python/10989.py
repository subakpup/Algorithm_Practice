import sys
input = sys.stdin.readline
arr = [0] * 10001

for _ in range(int(input())):
    arr[int(input())] += 1
    
for i in range(len(arr)):
    if arr[i] != 0:
        for _ in range(arr[i]):
            print(i)