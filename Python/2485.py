def gcd(a,b):
    while b!= 0:
        a,b = b,a%b
    return a

n = int(input())
tree = sorted(int(input()) for _ in range(n))
distance = [tree[i] - tree[i-1] for i in range(1,n)]

gcd_value = distance[0]
for i in distance[1:]:
    gcd_value = gcd(gcd_value, i)

res = 0
for j in distance:
    res += (j // gcd_value) - 1

print(res)