import sys, heapq
input = sys.stdin.readline

heap = []
for i in range(int(input())):
    n = int(input())
    if n != 0:
        heapq.heappush(heap, n)
    else:
        try:
            print(heapq.heappop(heap))
        except:
            print(0)