import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def pst(start, end):
    if start > end:
        return
    
    root = pre[start]
    i = start + 1
    
    while i <= end and pre[i] < root:
        i += 1
        
    pst(start + 1, i - 1)
    pst(i, end)
    print(root)

if __name__ == "__main__":
    pre = []
    while True:
        try:
            pre.append(int(input()))
        except:
            break
        
    pst(0, len(pre) - 1)