import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def int2bin(n):
    s = bin(n).replace("0b", "")
    return f'{"0" * (8 - len(s))}{s}'


def solve(s):
    nums = s.split('#')
    n = len(nums)
    if n != 4:
        return "invalid IP"
    for idx, x in enumerate(nums):
        if not x.isdigit():
            return "invalid IP"
        ix = int(x)
        if idx == 0 and (ix < 1 or ix > 128):
            return "invalid IP"
        elif idx != 0 and (ix < 0 or ix > 255):
            return "invalid IP"
    bin_x = "".join([int2bin(int(x)) for x in nums])
    return int(bin_x, 2)


for line in sys.stdin:
    ans = solve(line.strip())
    print(ans)
