import sys
input = sys.stdin.readline

n,m = map(int,input().split())
basket = [i for i in range(1, n+1)]

for _ in range(m):
    i,j,k = map(int,input().split())
    basket = basket[:i-1] + basket[k-1:j] + basket[i-1:k-1] + basket[j:]

print(*basket)