import sys, math
input = sys.stdin.readline

a,b,v = map(int,input().split())
d = (v-b)/(a-b)
print(math.ceil(d))