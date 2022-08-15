import re
import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(s):
    xys = []
    while s:
        res = re.search(r"([1-9][0-9]{0,2},[1-9][0-9]{0,2})", s)
        if res:
            xys.append(res.group())
            s = s[res.span()[1]:]
        else:
            break

    def _sort(x):
        a, b = x.split(",")
        return int(a) ** 2 + int(b) ** 2

    if xys:
        xys = sorted(xys, key=_sort, reverse=True)
        print(f"({xys[0]})")
    else:
        print("(0,0)")


for line in sys.stdin:
    s = line.strip()
    solve(s)
