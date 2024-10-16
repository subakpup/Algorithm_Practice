import sys
input = sys.stdin.readline

arr = sorted(int(input()) for _ in range(int(input())))
print(sum(arr)//len(arr))
print(arr[len(arr)//2])
