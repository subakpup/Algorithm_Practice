import sys
input = sys.stdin.readline

def distance(chicken):
    total = 0
    for x1,y1 in h:
        dist = 1e9
        for x2,y2 in chicken:
            dist = min(dist, abs(x1-x2) + abs(y1-y2))
        total += dist
    return total

def dfs(s,d):
    global answer
    if d == m:
        dist = distance(chicken)
        answer = min(answer, dist)
        return
    
    for i in range(s, len(ch)):
        chicken.append(ch[i])
        dfs(i+1, d+1)
        chicken.pop()

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
    chicken = []
    
    dfs(0,0)
    print(answer)