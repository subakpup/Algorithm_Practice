import sys
input = sys.stdin.readline

def func(x, y, n):
    tmp = arr[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if tmp != arr[i][j]:
                idx = n // 3
                for a in range(3):
                    for b in range(3):
                        func(x+idx*a, y+idx*b, idx)
                return
    res.append(tmp)

if __name__ == "__main__":
    n = int(input())
    arr = [list(map(int,input().split())) for _ in range(n)]
    res = []

    func(0,0,n)
    print(res.count(-1), res.count(0), res.count(1), sep='\n')