import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(n, nums):
    tot = sum(nums)
    nums = sorted(nums)
    xor = 0

    for i in nums:
        xor ^= i
    if xor == 0:
        print(tot - nums[0])
    else:
        print(-1)


while True:
    try:
        n = int(input().strip())
        nums = list(map(int, input().strip().split()))
        solve(n, nums)
    except Exception as e:
        break
