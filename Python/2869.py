# 올라가야할 거리: v-b
# 하루에 올라갈 수 있는 거리: a-b
import math
a,b,v = map(int,input().split())
n = (v-b)/(a-b)
print(math.ceil(n))