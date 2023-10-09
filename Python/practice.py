import sys
input = sys.stdin.readline

a = input().upper()
al = list(set(a))
arr = []

for i in al:
    arr.append(a.count(i))
print(arr)
if al.count(max(arr)) >1:
    print('?')
else:
    print(al[arr.index(max(arr))])