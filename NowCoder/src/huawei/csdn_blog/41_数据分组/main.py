import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(s):
    nums = list(map(int, s.split(",")))
    d = dict()
    for n in nums:
        d.setdefault(n, 0)
        d[n] += 1
    if len(set(d.values())) == 1:
        cnt = max(d.values())
        keys = sorted(d.keys())

        for k in keys:
            print(",".join([str(k)] * cnt))
    else:
        print(-1)


for line in sys.stdin:
    solve(line.strip())
