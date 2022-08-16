import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums, k):
    for i in range(len(nums)):
        if nums[i] < k:
            nums[i] = 1
        else:
            nums[i] = 0
    n = len(nums)
    m = sum(nums)
    ans = []
    for i in range(n):
        ans.append(sum(nums[i: i + m]))

    print(m - max(ans))


while True:
    try:
        nums = list(map(int, input().strip().split()))
        k = int(input().strip())
        solve(nums, k)
    except Exception as e:
        break
