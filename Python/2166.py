import sys
input = sys.stdin.readline

n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]

answer = 0
for i in range(n):
    x1,y1 = graph[i]
    x2,y2 = graph[(i+1) % n]
    answer += (x1 * y2 - x2 * y1)
answer = abs(answer) / 2

print(f'{answer:.1f}')