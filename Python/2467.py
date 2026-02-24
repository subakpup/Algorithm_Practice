import sys
input = sys.stdin.readline

def func():
    left, right = 0, n-1
    res = abs(arr[left] + arr[right])
    l, r = left, right
    
    while left < right:
        cur = arr[left] + arr[right]
        
        if abs(cur) < res:
            res = abs(cur)
            l, r = left, right
            
            if res == 0:
                break
            
        if cur < 0:
            left += 1
        else:
            right -= 1
    
    return arr[l], arr[r]

if __name__ == "__main__":
    n = int(input())
    arr = sorted(map(int,input().split()))
    print(*func())