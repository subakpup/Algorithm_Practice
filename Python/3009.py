import sys
input = sys.stdin.readline

A = []
B = []

for i in range(3):
    a,b = map(int,input().split())
    A.append(a), B.append(b)

for i in range(3):
    if A.count(A[i]) == 1:
        x = A[i]
    if B.count(B[i]) == 1:
        y = B[i]

print(x,y)