import sys
input = sys.stdin.readline

def isPalindrome(s):
    if s == s[::-1]:
        return True
    else:
        return False

for i in range(int(input())):
    s = input().strip().lower()
    print('Yes' if isPalindrome(s) else 'No')