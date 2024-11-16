import heapq
import sys
n = int(sys.stdin.readline())
card = []
for _ in range(n):
    heapq.heappush(card, int(sys.stdin.readline()))

res = 0
while len(card) > 1:
    tmp1 = heapq.heappop(card)
    tmp2 = heapq.heappop(card)
    res += tmp1 + tmp2
    heapq.heappush(card, tmp1 + tmp2)
print(res)
