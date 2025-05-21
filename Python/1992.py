import sys
input = sys.stdin.readline

def func(x, y, n):
    tmp = arr[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if arr[i][j] != tmp:
                half = n // 2
                return "(" + func(x, y, half) + func(x, y+half, half) + func(x+half, y, half) + func(x+half, y+half, half) + ")"
    return str(tmp)

if __name__ == "__main__":
    n = int(input())
    arr = [list(map(int, input().rstrip())) for _ in range(n)]
    print(func(0, 0, n))