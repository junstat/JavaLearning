import sys
from functools import cmp_to_key

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def cmp(a, b):
    sa = a + b
    sb = b + a
    if sa > sb:
        return -1
    elif sb > sa:
        return 1
    return 0


def solve(nums):
    nums.sort(key=cmp_to_key(cmp))
    print("".join(nums))


for line in sys.stdin:
    nums = line.strip().split(",")
    solve(nums)
