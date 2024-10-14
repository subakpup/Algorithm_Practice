import sys
input = sys.stdin.readline

dic = dict()
for i in range(int(input())):
    a,b = input().split()
    dic[a] = b
print(dic)