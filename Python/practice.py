gun = 10
def chck(sol):
    global gun
    gun -= sol
    print(f"남은 총 : {gun}")

print(f"전체 총 : {gun}")
chck(2)
print(f"남은 총 : {gun}")