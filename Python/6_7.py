c = int(input())

for i in range(c):
    n = list(map(int,input().split()))
    avg = sum(n[1:])/n[0]
    