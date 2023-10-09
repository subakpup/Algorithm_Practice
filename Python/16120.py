import sys
input = sys.stdin.readline

stack = []
a = input().rstrip()
rst = 'NP'
for i in a:
    stack.append(i)
    if len(stack) >= 4 and stack[-4:] == ['P','P','A','P']:
        stack.pop()
        stack.pop()
        stack.pop()
if len(stack) == 1 and stack[0] == 'P':
    rst = 'PPAP'
print(rst)