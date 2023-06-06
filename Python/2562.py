import sys
input = sys.stdin.readline

n = []
for i in range(9):
    n.append(int(input()))

print(max(n))
print(n.index(max(n))+1)