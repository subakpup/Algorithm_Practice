k = list(map(int,input()))
if len(k) != 1:
    n = k[0] - k[1]
    for i in range(len(k)-1):
        if k[i] - k[i+1] == n:
            print('◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!')
        else:
            print('흥칫뿡!! <(￣ ﹌ ￣)>')
else:
    print('◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!')