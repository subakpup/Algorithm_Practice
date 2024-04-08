import sys
input = sys.stdin.readline

n,m = map(int,input().split())
graph = []

for i in range(n):
    graph.append(input().strip())