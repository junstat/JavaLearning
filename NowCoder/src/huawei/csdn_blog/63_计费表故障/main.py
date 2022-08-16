import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(n):
    ans = n
    for i in range(1, n + 1):
        if '4' in str(i):
            ans -= 1
    print(ans)


while True:
    try:
        n = int(input().strip())
        solve(n)
    except Exception as e:
        break
