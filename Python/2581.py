import sys
input = sys.stdin.readline

m = int(input())
n = int(input())
result = []
for i in range(m, n+1):
    for j in range(2, i+1):
        if i % j == 0:
            if i == j:
                result.append(i)
            break
if result:
    print(sum(result))
    print(min(result))
else:
    print(-1)