import sys
input = sys.stdin.readline

def dfs():
    total = 0
    
    for x,y in h:
        

if __name__ == "__main__":
    n,m = map(int,input().split())
    graph = [list(map(int,input().split())) for _ in range(n)]
    
    h = []
    ch = []
    
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 1:
                h.append((i,j))
            elif graph[i][j] == 2:
                ch.append((i,j))
                
    answer = 1e9
    