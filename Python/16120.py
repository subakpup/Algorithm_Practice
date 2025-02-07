import sys
input = sys.stdin.readline

s = input().rstrip()
stk = []

for i in s:
    stk.append(i)
    if len(stk) >= 4 and stk[-4:] == ['P','P','A','P']:
        stk[-4:] = ['P']

print('PPAP' if stk == ['P'] else 'NP')