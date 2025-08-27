import sys
input = sys.stdin.readline

def floyd_warshall(n, dist):
    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
    return dist

if __name__ == "__main__":
    n = int(input())
    m = int(input())
    dist = [[int(1e9)] * (n+1) for _ in range(n+1)]
    for i in range(1, n+1):
        dist[i][i] = 0

    for _ in range(m):
        a, b, w = map(int, input().split())
        dist[a][b] = min(dist[a][b], w)

    dist = floyd_warshall(n, dist)

    for i in range(1, n+1):
        for j in range(1, n+1):
            print(0 if dist[i][j] == int(1e9) else dist[i][j], end=" ")
        print()
