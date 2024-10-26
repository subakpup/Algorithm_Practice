import sys
input = sys.stdin.readline

def dfs():
    if len(s) == m:
        print(*s)
        return
    for i in range(n):
        if arr[i] not in s:
            s.append(arr[i])
            dfs()
            s.pop()

if __name__ == '__main__':
    n,m = map(int,input().split())
    arr = sorted(map(int,input().split()))
    s = []
    dfs()