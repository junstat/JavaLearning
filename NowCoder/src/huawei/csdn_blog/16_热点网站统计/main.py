import sys
from collections import Counter

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(urls, n):
    cnt = Counter(urls)
    topn = cnt.most_common(n)
    print(",".join([x[0] for x in topn]))


urls = []
while True:
    try:
        line = input().strip()
        if line.isdigit():
            n = int(line)
            solve(urls, n)
        else:
            urls.append(line)
    except Exception as e:
        break
