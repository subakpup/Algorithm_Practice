import heapq, sys
input = sys.stdin.readline

t = int(input())
for tc in range(t):
    k = int(input())
    min_q, max_q = [], []
    visited = [False] * k
    
    for i in range(k):
        cmd, val = input().split()
        val = int(val)
        
        if cmd == 'I':
            heapq.heappush(min_q, (val, i))
            heapq.heappush(max_q, (-val, i))
            visited[i] = True
        
        elif cmd == 'D':
            if val == 1:
                while max_q and not visited[max_q[0][1]]:
                    heapq.heappop(max_q)
                
                if max_q:
                    visited[max_q[0][1]] = False
                    heapq.heappop(max_q)
            
            elif val == -1:
                while min_q and not visited[min_q[0][1]]:
                    heapq.heappop(min_q)
                
                if min_q:
                    visited[min_q[0][1]] = False
                    heapq.heappop(min_q)
    
    while max_q and not visited[max_q[0][1]]:
        heapq.heappop(max_q)
    while min_q and not visited[min_q[0][1]]:
        heapq.heappop(min_q)
    
    if max_q and min_q:
        print(-max_q[0][0], min_q[0][0])
    else:
        print("EMPTY")