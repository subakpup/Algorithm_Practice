import sys, random
input = sys.stdin.readline

arr = []
random.shuffle(arr)

print(*arr, sep='')