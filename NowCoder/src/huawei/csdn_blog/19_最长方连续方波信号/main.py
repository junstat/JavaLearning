import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(s):
    signals = []
    cache = []
    for c in s:
        if cache and cache[-1] == '0' == c:
            signals.append("".join(cache))
            cache = [c]
        else:
            cache.append(c)
    else:
        if cache:
            signals.append("".join(cache))

    # 取出不包含11，长度最大的子串
    ans = max(signals, key=lambda x: 0 if "11" in x else len(x))
    print(ans)


for line in sys.stdin:
    solve(line.strip())
