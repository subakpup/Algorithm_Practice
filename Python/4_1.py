import sys
input = sys.stdin.readline

n = int(input())
n_list = list(map(int,input().split()))
v = int(input())

print(n_list.count(v))