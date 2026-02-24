import sys
input = sys.stdin.readline

def func(x,y,n):
    color = arr[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if color != arr[i][j]:
                half = n//2
                func(x, y, half)
                func(x+half, y, half)
                func(x, y+half, half)
                func(x+half, y+half, half)
                return
    res.append(color)

if __name__ == "__main__":
    n = int(input())
    arr = [list(map(int,input().split())) for _ in range(n)]
    res = []
    
    func(0,0,n)
    print(res.count(0))
    print(res.count(1))