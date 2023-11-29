import sys
input = sys.stdin.readline

print(''.join(sorted(list(input().rstrip()), reverse=True)))