import sys, math
input = sys.stdin.readline

for tc in range(int(input())):
    x1, y1, r1, x2, y2, r2 = map(int,input().split())

    dis = math.sqrt((x2 - x1)**2 + (y2 - y1)**2)
    
    if dis == 0 and r1 == r2:
        print(-1)
    elif dis == r1 + r2 or dis == abs(r2 - r1):
        print(1)
    elif abs(r2 - r1) < dis < (r1 + r2):
        print(2)
    else:
        print(0)