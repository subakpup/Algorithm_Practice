import sys
input = sys.stdin.readline

def hanoi(n, dep, via, arr): # 개수, 출발, 경유, 도착
    if n == 1:
        print(dep, arr)
    else:
        hanoi(n-1, dep, arr, via) # n-1개: 1번 -> 3번 -> 2번
        print(dep, arr) # 가장 큰 원판: 1번 -> 3번
        hanoi(n-1, via, dep, arr) # n-1개: 2번 -> 1번 -> 3번

if __name__ == "__main__":
    n = int(input())
    print(2**n - 1)
    if n <= 20:
        hanoi(n, 1, 2, 3)