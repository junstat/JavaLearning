import sys
from itertools import permutations

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(words):
    ans = set()
    for x in permutations(words):
        cur = "".join(x)
        ans.add(cur)
    print(" ".join(ans))


while True:
    try:
        words = input().strip().split()
        solve(words)
    except Exception as e:
        break
