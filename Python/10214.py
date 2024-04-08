import sys
input = sys.stdin.readline

for i in range(int(input())):
    y = k = 0
    for i in range(9):
        y1,k1 = map(int,input().split())
        y += y1
        k += k1
    if y > k:
        print("Yonsei")
    elif y < k:
        print("Korea")
    else:
        print("Draw")