import sys
input = sys.stdin.readline

n = [i for i in range(1,31)]

for i in range(28):
    a = int(input())
    n.remove(a)

print(min(n))
print(max(n))