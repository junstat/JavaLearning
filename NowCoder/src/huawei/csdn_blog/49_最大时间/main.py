import sys
from itertools import permutations

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums):
    nums.sort(reverse=True)
    ans = ""
    for t in permutations(nums):
        if t[:2] < (2, 4) and t[2] < 6 and t[4] < 6:
            cur = "%d%d:%d%d:%d%d" % t
            if cur > ans:
                ans = cur
    print(ans)


for line in sys.stdin:
    nums = list(map(int, line.strip().split(",")))
    solve(nums)
