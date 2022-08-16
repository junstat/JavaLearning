import math
import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def check(p, k, h):
    ans = 0
    for x in p:
        ans += math.ceil(x / k)
    return ans <= h


def solve(nums, h):
    lo = 0
    hi = 0x3f3f3f3f
    while lo < hi:
        mid = lo + hi >> 1
        if check(nums, mid, h):
            hi = mid
        else:
            lo = mid + 1
    print(hi)


while True:
    try:
        ins = list(map(int, input().strip().split()))
        if len(ins) < 2 or min(ins) < 0:
            print(-1)
            break
        solve(ins[:-1], ins[-1])
    except Exception as e:
        break
