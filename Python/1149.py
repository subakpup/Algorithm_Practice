# 인접한 집과 같은 색 x
import sys
input = sys.stdin.readline

r = []
g = []
b = []

for i in range(int(input())):
    R,G,B = map(int,input().split())
    r.append(R); g.append(G); b.append(B)
