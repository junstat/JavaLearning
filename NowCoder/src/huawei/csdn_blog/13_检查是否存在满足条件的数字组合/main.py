import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums, n):
    nums.sort(reverse=True)
    for i in range(n - 2):
        l = i + 1
        r = n - 1
        t = nums[i]
        while l < r:
            m = nums[l] + 2 * nums[r]
            if m > t:
                l += 1
            elif m < t:
                r -= 1
            else:
                return nums[i], nums[l], nums[r]
    return 0


while True:
    try:
        n = int(input().strip())
        nums = list(map(int, input().strip().split()))
        ans = solve(nums, n)
        if ans == 0:
            print(0)
        else:
            print(" ".join(map(str, ans)))
    except Exception as e:
        break
