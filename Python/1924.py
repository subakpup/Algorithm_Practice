import sys
input = sys.stdin.readline

res = 0
days = [31,28,31,30,31,30,31,31,30,31,30,31]
week = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
x,y = map(int,input().split())

for i in range(x-1):
    res += days[i]
res = (res + y) % 7

print(week[res])