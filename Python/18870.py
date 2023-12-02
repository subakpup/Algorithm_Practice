import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int,input().split()))
arr = sorted(set(a))
dic = {arr[i]:i for i in range(len(arr))}

for i in a:
    print(dic[i], end = ' ')