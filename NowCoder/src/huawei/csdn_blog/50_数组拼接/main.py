import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(n, data):
    l = max([len(x) for x in data])
    ans = []
    for s in range(0, l, n):
        for x in data:
            if s < len(x):
                ans.extend(x[s: s + n])
    print(",".join(ans))


while True:
    try:
        n = int(input().strip())
        data = []
        for _ in range(n - 1):
            data.append(list(input().strip().split(",")))
        solve(n, data)
    except Exception as e:
        break
