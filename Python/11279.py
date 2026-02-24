import sys, heapq
input = sys.stdin.readline

heap = []
for _ in range(int(input())):
    x = int(input())
    if x != 0:
        heapq.heappush(heap, -x)
    else:
        try:
            print(-heapq.heappop(heap))
        except:
            print(0)