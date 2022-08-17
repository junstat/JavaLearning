import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(n, nums):
    nums.sort()
    d = []
    for x in nums:
        if not d:
            d.append(x)
        else:
            for y in d:
                if x % y == 0:
                    break
            else:
                d.append(x)
    print(len(d))


while True:
    try:
        n = int(input().strip())
        nums = list(map(int, input().strip().split()))
        solve(n, nums)
    except Exception as e:
        break
