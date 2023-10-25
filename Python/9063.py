a = []
b = []
for i in range(int(input())):
    A,B = map(int,input().split())
    a.append(A), b.append(B)

print((max(a)-min(a))*(max(b)-min(b)))