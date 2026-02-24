import sys
input = sys.stdin.readline

def func(n):
    arr = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            arr[i][j] = 1
            arr[j][i] = 1
            arr[j][j] = 1
        
if __name__ == '__main__':
    n = int(input())
    print(func(n))