import sys
input = sys.stdin.readline

for _ in range(int(input())):
    dic = {}
    for i in range(int(input())):
        c, name = input().split()
        dic[name] = int(c)
    print(max(dic, key=dic.get))