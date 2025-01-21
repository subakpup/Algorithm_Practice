import sys
input = sys.stdin.readline

def dfs(idx, v, add, sub, mul, div):
    global mx, mn

    if idx == n:
        mx = max(mx, v)
        mn = min(mn, v)
        return
    
    if add > 0:
        dfs(idx + 1, v + arr[idx], add - 1, sub, mul, div)
    if sub > 0:
        dfs(idx + 1, v - arr[idx], add, sub - 1, mul, div)
    if mul > 0:
        dfs(idx + 1, v * arr[idx], add, sub, mul - 1, div)
    if div > 0:
        if v < 0:
            dfs(idx + 1, -(abs(v) // arr[idx]), add, sub, mul, div - 1)
        else:
            dfs(idx + 1, v // arr[idx], add, sub, mul, div - 1)


if __name__ == '__main__':
    n = int(input())
    arr = list(map(int,input().split()))
    add, sub, mul, div = map(int,input().split())
    
    mx = int(-1e9)
    mn = int(1e9)

    dfs(1, arr[0], add, sub, mul, div)

    print(mx)
    print(mn)