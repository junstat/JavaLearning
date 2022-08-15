import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(intervals, n):
    ints = []
    for item in intervals:
        if "-" in item:
            s, e = map(int, item.split("-"))
            for i in range(s, e + 1):
                ints.append(i)
        else:
            x = int(item)
            ints.append(x)

    if n in ints:
        ints.remove(n)
    ints.sort()

    ans = []
    t = [ints[0]]
    for x in ints[1:]:
        if t[-1] + 1 == x:
            if len(t) < 2:
                t.append(x)
            else:
                t[-1] = x
        else:
            ans.append("-".join(map(str, t)))
            t = [x]
    if t:
        ans.append("-".join(map(str, t)))
    print(",".join(ans))


while True:
    try:
        intervals = input().strip().split(",")
        n = int(input().strip())
        solve(intervals, n)
    except Exception as e:
        break
