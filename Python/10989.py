import sys
input = sys.stdin.readline
result = 0
arr = [0] * 10001
for _ in range(int(input())):
    arr[int(input())] += 1

for i in range(10001):
    for j in range(arr[i]):
        print(i)