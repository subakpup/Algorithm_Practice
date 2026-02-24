s = input()
frame = [''] * 5

for i,c in enumerate(s):
    val = '#'

    if (i+1) % 3 == 0:
        val = '*'
        #frame[2] = frame[2][:-1]+val
                
    pattern = [
        f'..{val}..',
        f'.{val}.{val}.',
        f'{val}.{c}.{val}',
        f'.{val}.{val}.',
        f'..{val}..'
    ]
    
    for idx in range(5):
        if i == 0:
            frame[idx] += pattern[idx]
        else:
            frame[idx] += pattern[idx][1:]
            
for row in frame:
    print(row)