t = int(input())
base64 = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/'
for tc in range(1,t+1):
    s = input()
    bin_num = ''
    for i in range(len(s)):
        n = base64.index(s[i])
        bin_num += f'{n:06b}'

    res = ''
    for i in range(0,len(bin_num),8):
        num = int(bin_num[i:i+8], 2)
        res += chr(num)
    print(f'#{tc} {res}')