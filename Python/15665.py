import sys
input = sys.stdin.readline

def dfs():
    chk = 0
    if len(s) == m:
        print(*s)
        return
    for i in range(n):
        if chk != arr[i]:
            s.append(arr[i])
            chk = arr[i]
            dfs()
            s.pop()

if __name__ == '__main__':
    n,m = map(int,input().split())
    arr = sorted(map(int,input().split()))
    s = []
    dfs()