n,s = input(), input()
if s.count("A") > s.count("B"):
    print("A")
elif s.count("A") < s.count("B"):
    print("B")
else:
    print("Tie")