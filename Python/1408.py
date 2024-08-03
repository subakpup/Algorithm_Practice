import sys
input = sys.stdin.readline

h1, m1, s1 = list(map(int,input().split(':')))
h2, m2, s2 = list(map(int,input().split(':')))
total = (h2 * 3600 + m2 * 60 + s2) - (h1 * 3600 + m1 * 60 + s1)

if total < 0:
    total += 60 * 60 * 24

H = total // 3600
M = (total % 3600) // 60
S = total % 60

print('%02d:%02d:%02d' % (H,M,S))