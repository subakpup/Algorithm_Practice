import sys
input = sys.stdin.readline

def func():
    cnt = 0
    if sum(trees) % 3 == 0:
        for tree in trees:
            cnt += tree // 2
        if cnt >= (sum(trees) / 3):
            return "YES"
        else:
            return "NO"
    else:
        return "NO"

if __name__ == "__main__":
    n = int(input())
    trees = list(map(int, input().split()))
    print(func())
