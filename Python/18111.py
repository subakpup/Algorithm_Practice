import sys
input = sys.stdin.readline

n,m,b = map(int,input().split())
land = [list(map(int,input().split())) for _ in range(n)]
res = sys.maxsize
idx = 0

for floor in range(257):
    excess, lack = 0, 0

    for i in range(n):
        for j in range(m):
            if land[i][j] >= floor:
                excess += land[i][j] - floor
            else:
                lack += floor - land[i][j]

    if excess + b >= lack:
        if lack + (excess * 2) <= res:
            res = lack + (excess * 2)
            idx = floor

print(res, idx)