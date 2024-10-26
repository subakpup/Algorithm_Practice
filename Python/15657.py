import sys
input = sys.stdin.readline

def dfs(start):
    if len(s) == m:
        print(*s)
        return
    for i in range(start,n):
        s.append(arr[i])
        dfs(i)
        s.pop()

if __name__ == '__main__':
    n,m = map(int,input().split())
    arr = sorted(map(int,input().split()))
    s = []
    dfs(0)