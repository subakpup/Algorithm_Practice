import sys
input = sys.stdin.readline

dic = dict()
n,m = map(int,input().split())

for num in range(1, n+1):
    name = input().rstrip()
    dic[name] = num
    dic[num] = name

for j in range(m):
    s = input().rstrip()
    if s.isdigit():
        print(dic[int(s)])
    else:
        print(dic[s])