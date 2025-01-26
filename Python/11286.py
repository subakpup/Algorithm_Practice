import sys, heapq
input = sys.stdin.readline

heap = []
for i in range(int(input())):
    x = int(input())
    if x != 0:
        heapq.heappush(heap, [abs(x),x])
    else:
        print(heapq.heappop(heap)[1] if heap else 0)