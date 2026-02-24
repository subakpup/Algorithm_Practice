import sys
input = sys.stdin.readline

n = []
x,y = map(int,input().split())  # 세븐25 : y그램 당 x원
n.append(x*1000/y)
for i in range(int(input())):   # 세븐25를 제외한 편의점 개수
    x1, y1 = map(int,input().split())
    n.append(x1*1000/y1)

print("%.2f"%min(n))