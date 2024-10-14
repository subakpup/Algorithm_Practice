import sys
input = sys.stdin.readline

t = int(input())
arr = list(map(int,input().split()))
res = 0
lst = [0] * 80001

for i in range(80001):
    if i % 3 == 0 or i % 7 == 0:
        res += i
    lst[i] = res

for j in arr:
    print(lst[j])