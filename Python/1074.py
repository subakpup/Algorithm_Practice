import sys
input = sys.stdin.readline

def func(n,x,y,cnt):
    for i in range(x, x+2):
        for j in range(y, y+2):
            arr[i][j] = cnt
            cnt += 1

if __name__ == "__main__":
    n,r,c = map(int,input().split())
    arr = [[0] * (2**n) for _ in range(2**n)]
    func(n,0,0,0)
    print(arr)