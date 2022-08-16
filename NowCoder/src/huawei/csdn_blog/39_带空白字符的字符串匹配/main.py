import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(ss, p):
    s = ss.replace(" ", "").replace("\t", "")
    ans = 0
    while s:
        if p in s:
            i = s.index(p)
            s = s[i + 1:]
            ans += 1
        else:
            break
    print(ans)


while True:
    try:
        ss = input().strip()
        p = input().strip()
        solve(ss, p)
    except Exception as e:
        break
