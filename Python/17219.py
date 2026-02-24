import sys
input = sys.stdin.readline

n,m = map(int,input().split())
note = dict()

for _ in range(n):
    site,pw = input().split()
    note[site] = pw

for _ in range(m):
    search = input().rstrip()
    print(note[search])