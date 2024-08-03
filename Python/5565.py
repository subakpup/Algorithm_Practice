import sys
input = sys.stdin.readline

total = int(input())
arr = [int(input()) for i in range(9)]
print(total - sum(arr))