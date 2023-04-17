import sys
input = sys.stdin.readline

H,M = map(int,input().split())
T = int(input())

H += T // 60
M += T % 60

if M >= 60:
    H += 1
    M -= 60

if H >= 24:
    H -= 24

print(H,M)