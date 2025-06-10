from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    visited = [False] * 100001
    cnt = [0] * 100001
    queue = deque([n])
    visited[n] = True
    
    while queue:
        v = queue.popleft()
        
        if v == k:
            return cnt[v]
        
        if 0 <= v*2 < 100001 and not visited[v*2]:
            visited[v*2] = True
            cnt[v*2] = cnt[v]
            queue.append(v*2)
        
        if 0 <= v-1 < 100001 and not visited[v-1]:
            visited[v-1] = True
            cnt[v-1] = cnt[v] + 1
            queue.append(v-1)
            
        if 0 <= v+1 < 100001 and not visited[v+1]:
            visited[v+1] = True
            cnt[v+1] = cnt[v] + 1
            queue.append(v+1)
    
if __name__ == "__main__":
    n,k = map(int,input().split())
    print(bfs())