import sys
input = sys.stdin.readline

n = int(input())
nlst = list(map(int,input().split()))
m = int(input())
mlst = list(map(int,input().split()))

dic = dict()
for i in nlst:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1

for j in mlst:
    if j in dic:
        print(dic[j], end=' ')
    else:
        print(0, end=' ')
# print(' '.join(str(dic[j]) if j in dic else '0' for j in mlst))