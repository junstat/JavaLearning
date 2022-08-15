import sys
from collections import Counter

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums):
    for i in range(len(nums) - 1):
        if i % 2 == 0 and nums[i] < nums[i + 1]:
            nums[i], nums[i + 1] = nums[i + 1], nums[i]
        elif i % 2 == 1 and nums[i] > nums[i + 1]:
            nums[i], nums[i + 1] = nums[i + 1], nums[i]
    print(nums)


for line in sys.stdin:
    try:
        nums = list(map(int, line.strip().split()))
    except Exception as e:
        print([])
    else:
        solve(nums)
