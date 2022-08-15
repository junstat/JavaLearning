import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums, n):
    pass


while True:
    try:
        n = int(input().strip())
    except Exception as e:
        break
