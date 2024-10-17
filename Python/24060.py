import sys
input = sys.stdin.readline

def merge_sort(arr):
    if len(arr) == 1:
        return arr
    mid = (len(arr)+1)//2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    
    res = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            res.append(left[i])
            ans.append(left[i])
            i += 1
        else:
            res.append(right[j])
            ans.append(right[j])
            j += 1
    while i < len(left):
        res.append(left[i])
        ans.append(left[i])
        i += 1
    while j < len(right):
        res.append(right[j])
        ans.append(right[j])
        j += 1
    return res

a,k = map(int,input().split())
arr = list(map(int,input().split()))
ans = []
merge_sort(arr)

if len(ans) >= k:
    print(ans)
else:
    print(-1)