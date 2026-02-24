import sys
input = sys.stdin.readline

s = input().rstrip()
q = int(input())
cnt = [[0] * (len(s)+1) for _ in range(26)]

for i in range(len(s)):
    idx = ord(s[i]) - ord('a')
    for j in range(26):
        cnt[j][i+1] = cnt[j][i]
    cnt[idx][i+1] += 1

for _ in range(q):
    a,l,r = input().split()
    l,r = map(int,(l,r))
    idx = ord(a) - ord('a')
    print(cnt[idx][r+1] - cnt[idx][l])