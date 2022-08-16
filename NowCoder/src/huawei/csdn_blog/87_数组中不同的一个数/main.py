import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums):
    ans = 0
    for n in nums:
        ans ^= n
    print(ans)


for line in sys.stdin:
    nums = list(map(int, line.strip().split()))
    solve(nums)
