import sys
from collections import defaultdict
from functools import cmp_to_key

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def cmp(a, b):
    if len(a) == len(b):
        sa = sorted(a)
        sb = sorted(b)
        return 1 if sa > sb else -1
    return len(b) - len(a)


def solve(s, n, words):
    ans = [words[s]]
    map = defaultdict(list)

    for word in words:
        map[word[0]].append(word)

    while True:
        c = ans[-1][-1]
        candidates = map.get(c, [])
        if not candidates:
            print("".join(ans))
            return
        candidates.sort(key=cmp_to_key(cmp))
        ans.append(candidates.pop(0))


while True:
    try:
        s = int(input().strip())
        n = int(input().strip())
        words = [input().strip() for _ in range(n)]
        solve(s, n, words)
    except Exception as e:
        break
