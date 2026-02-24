from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    queue = deque([(a, 1)])
    
    while queue:
        node, cnt = queue.popleft()
        
        if node == b:
            return cnt
        
        if node * 2 <= b:
            queue.append((node * 2, cnt + 1))
            
        if int(str(node) + '1') <= b:
            queue.append((int(str(node) + '1'), cnt + 1))
    
    return -1

if __name__ == "__main__":
    a,b = map(int,input().split())
    print(bfs())