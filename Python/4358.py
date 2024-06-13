import sys
input = sys.stdin.readline

trees = {}
cnt = 0
while True:
    s = input().rstrip()
    if not s:
        break
    cnt += 1
    if s in trees:
        trees[s] += 1
    else:
        trees[s] = 1

trees = sorted(trees.items(), key= lambda x: x[0])

for key, value in trees:
    pct = value / cnt * 100
    print(f'{key} {pct:.4f}')