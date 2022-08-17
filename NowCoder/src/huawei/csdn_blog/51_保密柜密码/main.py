import sys
from itertools import combinations

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums, n):
    nums.sort()
    ans = []
    for i in range(n, len(nums) + 1):
        for x in combinations(nums, i):
            ans.append(x)
    ans.sort()
    for x in ans:
        print(",".join(x))


while True:
    try:
        nums = input().strip().split(",")
        n = int(input().strip())
        solve(nums, n)
    except Exception as e:
        break
