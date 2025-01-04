import sys
input = sys.stdin.readline

def func(s):
    if s == s[::-1]:
        return 'yes'
    return 'no'

if __name__ == "__main__":
    while True:
        s = input().rstrip()
        if s == '0':
            break
        print(func(s))