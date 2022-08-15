import sys
from collections import Counter

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(s):
    cnt_lower = dict()
    cnt_upper = dict()
    for c in s:
        if c.islower():
            cnt_lower.setdefault(c, 0)
            cnt_lower[c] += 1
        else:
            cnt_upper.setdefault(c, 0)
            cnt_upper[c] += 1
    cnt_lower = sorted(cnt_lower.items(), key=lambda x: (-x[1]))
    cnt_upper = sorted(cnt_upper.items(), key=lambda x: (-x[1]))
    ans = [f'{x[0]}:{x[1]}' for x in cnt_lower] + [f'{x[0]}:{x[1]}' for x in cnt_upper]
    print(";".join(ans))


def solve2(s):
    cnt = Counter(s)

    def cmp(x):
        if x[0].isupper():
            return x[1], -ord(x[0]) - 100
        return x[1], -ord(x[0])

    sorted_cnt = sorted(cnt.items(), key=cmp, reverse=True)
    print(":".join([f'{x[0]}:{x[1]}' for x in sorted_cnt]))


for line in sys.stdin:
    solve2(line.strip())
