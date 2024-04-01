from collections import deque
import sys
input = sys.stdin.readline

arr = deque(input().rstrip()[1:-1].split(","))
arr.reverse()

print(arr)