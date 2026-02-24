import sys
input = sys.stdin.readline

def dfs(a):
    if len(s) == m:
        print(*s)
        return
    for i in range(a,n+1):
        if i not in s:
            s.append(i)
            dfs(i+1)
            s.pop()

if __name__ == '__main__':
    n,m = map(int,input().split())
    s = []
    dfs(1)