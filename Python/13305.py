import sys
input = sys.stdin.readline

n = int(input()) # 도시의 개수
lng = list(map(int,input().split())) # 도시 사이의 거리
price = list(map(int,input().split())) # 각 도시의 기름값

chk = price[0] # 최소 기름값
res = 0 # 총 가격

for i in range(n-1):
    if chk > price[i]:
        chk = price[i]
    res += chk * lng[i]

print(res)