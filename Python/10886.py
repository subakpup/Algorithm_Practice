import sys
input = sys.stdin.readline

arr = [int(input()) for _ in range(int(input()))]
if arr.count(1) > arr.count(0):
    print("Junhee is cute!")
else:
    print("Junhee is not cute!")