import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(powers, limit):
    powers.sort(reverse=True)
    n = len(powers)
    cnt = 0
    l = 0
    r = n - 1

    while l < r:
        if powers[l] >= limit:
            cnt += 1
            l += 1
        elif powers[l] + powers[r] >= limit:
            cnt += 1
            l += 1
            r -= 1
        elif powers[l] + powers[r] < limit:
            r -= 1
    print(cnt)


while True:
    try:
        _ = input()
        powers = list(map(int, input().strip().split()))
        limit = int(input().strip())
        solve(powers, limit)
    except Exception as e:
        break
