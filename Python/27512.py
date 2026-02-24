import sys
input = sys.stdin.readline

def snake(n,m):
    return n * m - 1 if n % 2 != 0 and m % 2 != 0 else n * m

if __name__ == "__main__":
    n,m = map(int,input().split())
    print(snake(n,m))