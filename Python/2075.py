import sys, heapq
input = sys.stdin.readline

n = int(input())
heap = []

for _ in range(n):
    row = list(map(int,input().split()))
    for r in row:
        heapq.heappush(heap, r)
        if len(heap) > n:
            heapq.heappop(heap)
print(heap[0])