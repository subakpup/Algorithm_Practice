import sys
input = sys.stdin.readline

def dfs(start):
    if len(s) == m:
        print(*s)
        return
    for i in range(start, n+1):
        s.append(i)
        dfs(i)
        s.pop()

if __name__ == '__main__':
    n,m = map(int,input().split())
    s = []
    dfs(1)