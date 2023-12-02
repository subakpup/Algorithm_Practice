import sys
input = sys.stdin.readline

lst = []

for i in range(int(input())):
<<<<<<< HEAD
    [a,b] = map(str, input().split())
    lst.append([a, b])
lst.sort()
lst.sort(key=lambda x:x[0])

=======
    a,b = map(str,input().split())
    a = int(a)
    lst.append((a,b))

lst.sort(key= lambda x:x[0])
>>>>>>> c9cc8b4165afb6a00addb880d8660482e69d64b2
for j in lst:
    print(j[0], j[1])