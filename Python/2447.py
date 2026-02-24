import sys
input = sys.stdin.readline

def star(n):
    if n == 1:
        return '*'
    
    stars = star(n//3)
    lst = []
    for i in stars:
        lst.append(i*3)
    for i in stars:
        lst.append(i+' '*(n//3)+i)
    for i in stars:
        lst.append(i*3)
    
    return lst

n = int(input())
print('\n'.join(star(n)))