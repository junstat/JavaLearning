import sys
from itertools import combinations

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums):
    ans = t = sum(nums)
    for left in combinations(nums, 5):
        ans = min(ans, abs(t - 2 * sum(left)))
        if ans == 0:
            break
    print(ans)


for line in sys.stdin:
    nums = list(map(int, line.strip().split()))
    solve(nums)
