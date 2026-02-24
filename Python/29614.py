import sys
input = sys.stdin.readline

if __name__ == "__main__":
    grade = {'A+':4.5,'A':4.0,'B+':3.5,'B':3.0,'C+':2.5,'C':2.0,'D+':1.5,'D':1.0,'F':0.0}
    
    s = input()
    arr = []
    for i in range(len(s)-1):
        if s[i] == "+":
            continue
        
        if s[i+1] == "+":
            arr.append(s[i]+"+")
        else:
            arr.append(s[i])
    
    answer = 0
    for a in arr:
        answer += grade[a]
        
    print(answer / len(arr))