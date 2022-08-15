import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(s):
    ans = 0
    stk = []
    for c in s:
        if c in "{[(":
            stk.append(c)
        else:
            if not stk:
                return 0
            ans = max(ans, len(stk))
            top = stk.pop()
            if f"{top}{c}" not in ("()", "{}", "[]"):
                return 0
    return ans


for line in sys.stdin:
    res = solve(line.strip())
    print(res)
