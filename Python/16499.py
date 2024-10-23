import sys
input = sys.stdin.readline

arr = set()
for _ in range(int(input())):
    arr.add(''.join(sorted(input().rstrip())))
print(arr)