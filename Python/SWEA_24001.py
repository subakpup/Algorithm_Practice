def change(s,v):
    arr = s[:]
    for i in range(len(s)):
        if s[i] == '?':
            arr[i] = v
    return arr

def distance(arr):
    d = [0]
    for i in range(len(arr)):
        if arr[i] == 'L':
            d.append(d[-1] - 1)
        else:
            d.append(d[-1] + 1)

    return max(max(d), -min(d))

t = int(input())
for tc in range(1, t+1):
    s = list(input())

    l = change(s,'L')
    r = change(s,'R')

    answer = max(distance(l), distance(r))
    print(answer)