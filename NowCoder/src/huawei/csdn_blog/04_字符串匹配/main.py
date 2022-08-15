import re
import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(ss, p):
    ans = []
    for idx, s in enumerate(ss):
        if re.match(p, s):
            ans.append(str(idx))
    if ans:
        print(",".join(ans))
    else:
        print("-1")


while True:
    try:
        ss = input().strip().split()
        p = input().strip()
        solve(ss, p)
    except Exception as e:
        break
